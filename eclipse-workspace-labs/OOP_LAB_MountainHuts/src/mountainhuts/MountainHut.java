package mountainhuts;

import java.util.Optional;

/**
 * Represents a mountain hut.
 * 
 * It is linked to a {@link Municipality}
 *
 */
public class MountainHut {
	private String category;
	private Integer numeberOfBeds;
	private Municipality municipality;
	private String name;
	private Optional<Integer> altitude;
	
	public MountainHut(String name, String category, Integer bedsNumber,
			Municipality municipality) {
		this.name = name;
		this.category = category;
		this.numeberOfBeds = bedsNumber;
		this.municipality = municipality;
	}
	
	
	public void setAltitude(Integer altitude) {
		this.altitude = Optional.of(altitude);
	}


	public String getName() {
		return this.name;
	}

	public Optional<Integer> getAltitude() {
			return altitude;		
	}

	public String getCategory() {
		return this.category;
	}

	public Integer getBedsNumber() {
		return this.numeberOfBeds;
	}

	public Municipality getMunicipality() {
		return this.getMunicipality();
	}

}
