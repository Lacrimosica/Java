import taxi.*;

public class MainClass {

    public static void main(String[] args) {
	TaxiCompany company = new TaxiCompany();
	Place luogo1 = new Place("Via Roma 10", "centro");
	Place luogo2 = new Place("Corso Francia 105", "cit turin");
	Place luogo3 = new Place("Corso Duca Abruzzi 24", "crocetta");
	Passenger passeggero1 = new Passenger(luogo1);
	Passenger passeggero2 = new Passenger(luogo1);
	Passenger passeggero3 = new Passenger(luogo3);
	try {
	    company.addTaxi("Taxi1");
	    company.addTaxi("Taxi2");
	    company.addTaxi("Taxi1");
	} catch (InvalidTaxiName itn) {
	    System.out.println(itn);
	}
	Taxi t = company.callTaxi(passeggero1);
	if (t != null) {
	    System.out.println("Assigned  " + t); // Assigned Taxi1
	} else
	    System.out.println("Call lost");
	t.beginTrip(luogo2);
	System.out.println(t + ": left from " + passeggero1.getPlace() + ", destination " + luogo2);
	// Taxi1: left from Via Roma 10, destination Corso Francia 105
	t.terminateTrip();
	System.out.println(t + ": arrived at " + passeggero1.getPlace()); // Taxi1:
									  // arrived
									  // at
									  // Corso
									  // Francia
									  // 105

	t = company.callTaxi(passeggero2);
	if (t != null) {
	    System.out.println("Assigned " + t); // Assigned Taxi2
	} else
	    System.out.println("Call lost");

	t.beginTrip(luogo3);
	System.out.println(t + ": left from " + passeggero2.getPlace() + ", destination " + luogo3);
	// Taxi2: left from Via Roma 10, destination Corso Duca Abruzzi 24
	t.terminateTrip();
	System.out.println(t + ": arrived at " + passeggero2.getPlace()); // Taxi2:
									  // arrived
									  // at
									  // Corso
									  // Duca
									  // Abruzzi
									  // 24

	t = company.callTaxi(passeggero1);
	if (t != null) {
	    System.out.println("Assigned " + t); // Assigned Taxi1
	} else
	    System.out.println("Call lost");
	t.beginTrip(luogo3);
	System.out.println(t + ": left from " + passeggero1.getPlace() + ", destination " + luogo3);
	t.terminateTrip();
	System.out.println(t + ": arrived at " + passeggero1.getPlace());

	t = company.callTaxi(passeggero1);
	if (t != null) {
	    System.out.println("Assigned " + t); // Assigned Taxi2
	} else
	    System.out.println("Call lost");

	t = company.callTaxi(passeggero2);
	if (t != null) {
	    System.out.println("Assigned " + t); // Assigned Taxi1
	} else
	    System.out.println("Call lost");

	t = company.callTaxi(passeggero3);
	if (t != null) {
	    System.out.println("Assigned " + t);
	} else
	    System.out.println("Call lost"); // Call lost

	System.out.println("Corse effettuate da Taxi1");
	try {
	    for (Trip c : company.getTrips("Taxi1"))
		System.out.println("  " + c); // Via Roma 10, Corso Francia 105
	} // Corso Francia 105, Corso Duca Abruzzi 24
	catch (InvalidTaxiName itn) {
	    System.out.println(itn);
	}

	System.out.println("Trips performed by Taxi2");
	try {
	    for (Trip c : company.getTrips("Taxi2"))
		System.out.println("  " + c); // Via Roma 10, Corso Duca Abruzzi
					      // 24
	} catch (InvalidTaxiName itn) {
	    System.out.println(itn);
	}
	System.out.println("Lost calls: " + company.getLostTrips()); // Lost
								     // calls: 1

	System.out.println("Statis Taxi:");
	for (InfoI info : company.statsTaxi())
	    System.out.println(info.getId() + " " + info.getValue()); // Taxi1 2
								      // Taxi2 1

	System.out.println("Stats Districts:");
	for (InfoI info : company.statsDistricts())
	    System.out.println(info.getId() + " " + info.getValue()); // crocetta
								      // 2
								      // cit
								      // turin 1
    }
}
