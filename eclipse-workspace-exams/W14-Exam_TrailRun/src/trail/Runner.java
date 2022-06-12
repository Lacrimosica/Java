package trail;

public class Runner implements Comparable<Runner> {

    private String name, surname;
    private int bibNumber;

    public Runner(int bibNumber, String name, String surname) {
	this.bibNumber = bibNumber;
	this.name = name;
	this.surname = surname;
    }

    public int getBibNumber() {
	return bibNumber;
    }

    public String getName() {
	return name;
    }

    public String getSurname() {
	return surname;
    }

    @Override
    public int compareTo(Runner other) {
	if (!this.getSurname().equals(other.getSurname()))
	    return this.getSurname().compareTo(other.getSurname());
	else if (!this.getName().equals(other.getName()))
	    return this.getName().compareTo(other.getName());
	else
	    return Integer.compare(this.getBibNumber(), other.getBibNumber());
    }

}
