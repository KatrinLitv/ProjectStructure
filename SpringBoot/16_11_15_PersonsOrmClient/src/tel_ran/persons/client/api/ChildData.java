package tel_ran.persons.client.api;

import java.util.Date;

public class ChildData extends PersonData{
String garten;


public ChildData() {
	super();
	type = "Child";
}

public ChildData(int id, String name, Date birthdate, String city, String street, int bld, String garten) {
	super(id, name, birthdate, city, street, bld);
	this.garten = garten;
	type = "Child";
}



public String getGarten() {
	return garten;
}


}
