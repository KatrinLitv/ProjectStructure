package tel_ran.persons.model.entites;
import java.time.LocalDate;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.*;
import static tel_ran.persons.api.PersonsConstants.*;

@Entity
///@Inheritance(strategy=)
public class Employee extends Person {

	String companyName;
	int salary;
	public Employee(){};
	public Employee(int id, String name, LocalDate birthdate, Address address, String companyName, int salary) {
		super(id, name, birthdate, address);
		this.companyName = companyName;
		this.salary = salary;
	}
	
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [companyName=" + companyName + ", salary=" + salary + ", id=" + id + ", name=" + name
				+ ", birthdate=" + birthdate + ", address=" + address + "]";
	}
	
	@Override
	public void setData(Map<String,Object>data) throws IllegalArgumentException {
		super.setData(data);
		try {
			companyName = ( String ) data.get( COMPANY );
			Integer Salary = ( Integer ) data.get( SALARY );
			salary = Salary == null ? 0 : Salary;
		} catch (Exception e) {
			throw new IllegalArgumentException("Wrong field/s of Emploeey");
		}
		
	}
		

}
