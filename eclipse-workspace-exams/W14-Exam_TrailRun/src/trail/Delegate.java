package trail;

public class Delegate {
    private String name, surname, ssn;

    public Delegate(String ssn, String surname, String name) {
	this.name = name;
	this.surname = surname;
	this.ssn = ssn;
    }

    @Override
    public String toString() {
	return surname + ", " + name + ", " + ssn;
    }

    String getName() {
        return name;
    }

    String getSurname() {
        return surname;
    }

    String getSsn() {
        return ssn;
    }

}
