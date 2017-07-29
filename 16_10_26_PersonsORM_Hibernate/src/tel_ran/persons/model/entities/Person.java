package tel_ran.persons.model.entities;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="bsh_persons")
public abstract class Person {
@Id
int id; //TZ
String name;
//int birthYear;
LocalDate birthDate;
@Embedded
Address address;

abstract public String toString();
public Person(){};
public Person(int id, String name, LocalDate birthDate, Address address) {
	super();
	this.id = id;
	this.name = name;
	this.birthDate = birthDate;
	this.address = address;
}

public int getId() {
	return id;
}

public String getName() {
	return name;
}

public Address getAddress() {
	return address;
}

public void setName(String name) {
	this.name = name;
}

public void setAddress(Address address) {
	this.address = address;
}

public LocalDate getBirthDate() {
	return birthDate;
}
public void setBirthDate(LocalDate birthDate) {
	this.birthDate = birthDate;
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
	Person other = (Person) obj;
	if (id != other.id)
		return false;
	return true;
}

}
