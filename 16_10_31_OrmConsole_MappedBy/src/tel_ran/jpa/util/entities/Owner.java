package tel_ran.jpa.util.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="10_31_Owner")
public class Owner {
@Id
int id;
String name;
String city;
@ManyToMany(mappedBy="owners")
Set<Car> cars;
int birthYear;

public Owner(){};
public Owner(int id, String name, String city, int birthYear) {
	super();
	this.id = id;
	this.name = name;
	this.city = city;
	this.birthYear = birthYear;
}
public int getId() {
	return id;
}
public String getName() {
	return name;
}
public String getCity() {
	return city;
}
public Set<Car> getCars() {
	return cars;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Owner other = (Owner) obj;
	if (id != other.id)
		return false;
	return true;
}
@Override
public String toString() {
	return "Owner [id=" + id + ", name=" + name + ", city=" + city + ", birthYear=" + birthYear + "]";
}





}
