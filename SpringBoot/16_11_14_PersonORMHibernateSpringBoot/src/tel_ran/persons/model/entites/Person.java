package tel_ran.persons.model.entites;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;
import javax.persistence.*;
import static tel_ran.persons.api.PersonsConstants.*;

@Entity
@Table(name="bsh_persons")
public abstract class Person {
	//@Generated value - генерированное ID
	@Id
	int id; // TZ
	String name;
	LocalDate birthdate;
	
	@Embedded
	Address address;
	abstract public String toString();
	
	public Person(int id, String name, LocalDate birthYaer, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthYaer;
		this.address = address;
	}
	
	public Person() {
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public LocalDate getBirthYaer() {
		return birthdate;
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

	public void setData(Map<String,Object> data) throws IllegalArgumentException {
		if( data==null ) 
			new IllegalArgumentException("Data is null");
		try {
			if( id==0 ) {
				Integer Id=(Integer) data.get(ID);
				if ( Id!=0 ) 
					id = Id;
			}
			name = (String) data.get( NAME );
			Date tmp = new Date((long) data.get( BIRTH_DATE ));
			birthdate = tmp.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			String street = (String) data.get( STREET );
			String city = (String) data.get( CITY );
			Integer bld = (Integer) data.get( BUILDING );
			address = new Address ( city, street, bld==null ? 0 : bld );
		} catch (Exception e) {
			throw new IllegalArgumentException("Wrong data in the map");
		}
		 
	}
	
	

	
}
