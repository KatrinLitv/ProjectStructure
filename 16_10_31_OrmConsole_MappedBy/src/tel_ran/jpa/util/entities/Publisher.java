package tel_ran.jpa.util.entities;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="2016_10_31_Publisher")
public class Publisher {
@Id
String name;
@Embedded
Address address;
@OneToMany(mappedBy="publisher")
Set<Book> books;

public Publisher(){};
public Publisher(String name, Address address) {
	super();
	this.name = name;
	this.address = address;
}
@Override
public String toString() {
	return "Publisher [name=" + name + ", address=" + address + "]";
}
public String getName() {
	return name;
}
public Address getAddress() {
	return address;
}

}
