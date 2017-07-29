package tel_ran.persons.model.entities;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Employee extends Person {
String company;
int salary;

public Employee(){};
public Employee(int id, String name, LocalDate birthDate, Address address, String company, int salary) {
	super(id, name, birthDate, address);
	this.company = company;
	this.salary = salary;
}

@Override
public String toString() {
	return "Employee [company=" + company + ", salary=" + salary + ", id=" + id + ", name=" + name + ", birthDate="
			+ birthDate + ", address=" + address + "]";
}



public String getCompany() {
	return company;
}

public int getSalary() {
	return salary;
}

public void setCompany(String company) {
	this.company = company;
}

public void setSalary(int salary) {
	this.salary = salary;
}


}
