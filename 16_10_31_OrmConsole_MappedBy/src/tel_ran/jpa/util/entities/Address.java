package tel_ran.jpa.util.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable{
String country;
String city;


public Address(){};
public Address(String country, String city) {
	super();
	this.country = country;
	this.city = city;
}

@Override
public String toString() {
	return "Address [country=" + country + ", city=" + city + "]";
}

}
