package mountainhuts;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summingInt;

import java.util.stream.Stream.*;
import static java.util.stream.Collectors.mapping;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.text.html.MinimalHTMLWriter;

/**
 * Class {@code Region} represents the main facade
 * class for the mountains hut system.
 * 
 * It allows defining and retrieving information about
 * municipalities and mountain huts.
 *
 */
public class Region {
	String name;
	List<AltitudeRange> altitude_ranges;
	Set<Municipality> municipalities;
	private Set<MountainHut> mountainhuts;
	
	
	public Region(String name) {
		this.name = name;
		altitude_ranges = new ArrayList<AltitudeRange>();
		municipalities = new TreeSet<Municipality>();
		mountainhuts = new TreeSet<MountainHut>();
	}

	public String getName() {
		return this.name;
	}

	public void setAltitudeRanges(String... ranges) {
		
		for(String s: ranges) {
			altitude_ranges.add(new AltitudeRange(s));
		}
	}

	
	public String getAltitudeRange(Integer altitude) {
		return altitude_ranges.stream()
				.filter( r -> r.includes(altitude) )
				.findFirst()
				.orElse(AltitudeRange.DEFAULT).toString();
	}
	
	private String getAltitudeRange(MountainHut x) {
		if (x.getAltitude().isPresent()) {
			return getAltitudeRange(x.getAltitude().get());
		} else {
			return getAltitudeRange(x.getMunicipality().getAltitude());
		}
	}

	public Municipality createOrGetMunicipality(String name, String province, Integer altitude) {
		for(Municipality m: municipalities) {
			if(m.getName().compareTo(name) == 0) {
				return m;
			}
		}
		Municipality mn = new Municipality(name, province, altitude);
		return mn;
	}

	public Collection<Municipality> getMunicipalities() {
		return Collections.unmodifiableCollection(municipalities);
	}

	public MountainHut createOrGetMountainHut(String name, String category, Integer bedsNumber,
			Municipality municipality) {
			
		for(MountainHut mh: mountainhuts) {
			if(mh.getName().compareTo(name) == 0) {
				return mh;
			}
		}
		MountainHut mnh = new MountainHut(name, category, bedsNumber, municipality);
		return mnh;
	}

	public MountainHut createOrGetMountainHut(String name, Integer altitude, String category, Integer bedsNumber,
			Municipality municipality) {
	
			MountainHut mh = createOrGetMountainHut(name, category, bedsNumber, municipality);
			mh.setAltitude(altitude);
		return mh;
	}

	public Collection<MountainHut> getMountainHuts() {
		return Collections.unmodifiableCollection(mountainhuts);
	}

 
	public static Region fromFile(String name, String file) {
		Region r = new Region(name);
		List<String> lines = Region.readData(file);

		String[] headers = lines.remove(0).split(";");
		Map<String, Integer> h2i = new HashMap<>();
		for(int i =0 ; i< headers.length ; i++) {
			h2i.put(headers[i], i);
		}
		
		lines.forEach(row -> {
			String[] cells = row.split(";");

			String municipalityName = cells[h2i.get("Municipality")];
			String municipalityProvince = cells[h2i.get("Province")];
			Integer municipalityAltitude = Integer.parseInt(cells[h2i.get("MunicipalityAltitude")]);
			Municipality municipality = r.createOrGetMunicipality(municipalityName, municipalityProvince,
					municipalityAltitude);

			String hutName = cells[h2i.get("Name")];
			String altitude = cells[h2i.get("Altitude")];
			String category = cells[h2i.get("Category")];
			Integer bedsNumber = Integer.parseInt(cells[h2i.get("BedsNumber")]);

			if (altitude.equals("")) {
				r.createOrGetMountainHut(hutName, category, bedsNumber, municipality);
			} else {
				r.createOrGetMountainHut(hutName, Integer.parseInt(altitude), category, bedsNumber, municipality);
			}
		});

		return r;
	}


	@SuppressWarnings("unused")
	private static List<String> readData(String file) {
		try (BufferedReader in = new BufferedReader(new FileReader(file))) {
			return in.lines().collect(toList());
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	public Map<String, Long> countMunicipalitiesPerProvince() {
		
		return municipalities.stream()
				.collect(groupingBy(Municipality::getProvince,counting()));
	}

	/**
	 * Count the number of mountain huts per each municipality within each province.
	 * 
	 * @return a map with the province as key and, as value, a map with the
	 *         municipality as key and the number of mountain huts as value
	 */
	public Map<String, Map<String, Long>> countMountainHutsPerMunicipalityPerProvince() {
	
		return mountainhuts.stream()
				.collect(groupingBy(x -> x.getMunicipality().getProvince(),
						groupingBy( x -> x.getMunicipality().getName(),
								counting())));
	}

	/**
	 * Count the number of mountain huts per altitude range. If the altitude of the
	 * mountain hut is not available, use the altitude of its municipality.
	 * 
	 * @return a map with the altitude range as key and the number of mountain huts
	 *         as value
	 */
	
	
	public Map<String, Long> countMountainHutsPerAltitudeRange() {

		Map<String,Long> res = mountainhuts.stream()
				.map(this::getAltitudeRange)
				.collect(groupingBy(r->r, 			// key mapper
						            counting()));	// downstream
		// adds also altitude ranges with no mountain huts
		altitude_ranges.stream().map(AltitudeRange::toString).forEach(r -> res.putIfAbsent(r, 0L));
		return res;
	}

	public Map<String, Integer> totalBedsNumberPerProvince() {
		return mountainhuts.stream()
				.collect(groupingBy(x -> x.getMunicipality().getProvince(),
								    summingInt(MountainHut::getBedsNumber)));
	}

	public Map<String, Optional<Integer>> maximumBedsNumberPerAltitudeRange() {
		Map<String, Optional<Integer>> res = mountainhuts.stream()
				.collect(groupingBy(this::getAltitudeRange, 
						mapping(MountainHut::getBedsNumber, maxBy(Comparator.naturalOrder()))));
				altitude_ranges.stream().map(x -> x.toString()).forEach(r -> res.putIfAbsent(r, Optional.of(0)));
		return res;
	}

	public Map<Long, List<String>> municipalityNamesPerCountOfMountainHuts() {
		return mountainhuts.stream().map(x -> x.getMunicipality().getName())
				.collect(groupingBy(x -> x, TreeMap::new, counting())).entrySet().stream()
				.collect(groupingBy(Map.Entry::getValue,
						mapping(Map.Entry::getKey, toList())));
	}
	


}
