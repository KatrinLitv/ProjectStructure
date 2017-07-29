package tel_ran.persons.client.api;

import java.util.*;

public class PersonData {
int id;
String type;
String name;
Date birthdate;

String city;
String street;
int bld;

public PersonData(){};
public PersonData(int id, String name, Date birthdate, String city, String street, int bld) {
	super();
	this.id = id;
	this.name = name;
	this.birthdate = birthdate;
	this.city = city;
	this.street = street;
	this.bld = bld;
	this.type="Person";
}
public int getId() {
	return id;
}
public String getType() {
	return type;
}
public String getName() {
	return name;
}
public Date getBirthdate() {
	return birthdate;
}
public String getCity() {
	return city;
}
public String getStreet() {
	return street;
}
public int getBld() {
	return bld;
}


}
