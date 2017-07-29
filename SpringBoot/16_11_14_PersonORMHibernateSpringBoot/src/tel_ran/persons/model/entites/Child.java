package tel_ran.persons.model.entites;

import java.time.LocalDate;
import java.util.Map;
import static tel_ran.persons.api.PersonsConstants.*;
import javax.persistence.Entity;

@Entity
public class Child extends Person {
	String garten;
	

	public Child(int id, String name, LocalDate birthdate, Address address, String garten) {
		super(id, name, birthdate, address);
		this.garten = garten;
	}

	public Child() {
		super();
	}

	@Override
	public String toString() {
		return "Child [garten=" + garten + ", id=" + id + ", name=" + name + ", birthYaer=" + birthdate + ", address="
				+ address + "]";
	}

	public String getGarten() {
		return garten;
	}

	public void setGarten(String garten) {
		this.garten = garten;
	}
	
	@Override
	public void setData(Map<String,Object>data) throws IllegalArgumentException {
		super.setData(data);
		try {
			garten = (String) data.get( GARTEN );
		} catch (Exception e) {
			throw new IllegalArgumentException("Wrong garten value");
		}
	}
	
	

	
}
