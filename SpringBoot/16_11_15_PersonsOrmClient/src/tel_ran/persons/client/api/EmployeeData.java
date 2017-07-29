package tel_ran.persons.client.api;

import java.util.Date;

public class EmployeeData extends PersonData {
String companyname;
int salary;

public EmployeeData() {
	super();
	type = "Employee";
}

public EmployeeData(int id, String name, Date birthdate, String city, String street, int bld, String companyname, int salary) {
	super(id, name, birthdate, city, street, bld);
	this.companyname = companyname;
	this.salary = salary;
	type = "Employee";
}

public String getCompanyname() {
	return companyname;
}

public int getSalary() {
	return salary;
}



}
