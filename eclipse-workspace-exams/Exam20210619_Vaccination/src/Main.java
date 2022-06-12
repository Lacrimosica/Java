//import java.time.temporal.WeekFields;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import it.polito.oop.vaccination.TimeSlot;
//
//public class Main {
//	
//	public static void main(String[] args) {
//		List<Integer> weeklyHours =Arrays.asList(2,2,2,2,2,1,1);
//	
//		
//		List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
//		
//		for(Integer i: weeklyHours) {
//			for(int j =0 ; j< i ; j++) {
////				List<TimeSlot> daily = (ArrayList<TimeSlot>) Stream.iterate(new TimeSlot(j+9,0), t -> new TimeSlot(j, t.getMin() +15)).limit(4).collect(Collectors.toList());
//
//				int h = j+9;
//				Stream.iterate(new TimeSlot(h,0), t -> new TimeSlot(h, t.getMin() +15)).limit(4).forEach(System.out::println);
////				List<String> dailySlotsString = (ArrayList<String>) daily.stream().map(t -> t.toString()).collect(Collectors.toList());
//			
//			}
//			System.out.println("-----");
//		}
////		return res;
//	}
//		
//		
//}
