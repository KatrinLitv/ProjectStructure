package tel_ran.jpa.util.entities;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="10_31_Car")
public class Car {
@Id
long regNumber;
String color;
@ManyToMany
Set<Owner> owners;
@ManyToOne
Model model;
int price;

public Car(){};
public Car(long regNumber, String color, int price) {
	super();
	this.regNumber = regNumber;
	this.color = color;
	this.price = price;
}
public long getRegNumber() {
	return regNumber;
}
public String getColor() {
	return color;
}
public Set<Owner> getOwners() {
	return owners;
}
public Model getModel() {
	return model;
}
public int getPrice() {
	return price;
}


public void setColor(String color) {
	this.color = color;
}
public void setOwners(Set<Owner> owners) {
	this.owners = owners;
}
public void setModel(Model model) {
	this.model = model;
}
public void setPrice(int price) {
	this.price = price;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (regNumber ^ (regNumber >>> 32));
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
	Car other = (Car) obj;
	if (regNumber != other.regNumber)
		return false;
	return true;
}
@Override
public String toString() {
	return "Car [regNumber=" + regNumber + ", color=" + color + ", owners=" + owners + ", model=" + model + ", price="
			+ price + "]";
}






}
