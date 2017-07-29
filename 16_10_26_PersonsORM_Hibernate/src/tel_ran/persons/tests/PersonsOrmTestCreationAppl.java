package tel_ran.persons.tests;

import java.time.LocalDate;

import org.springframework.beans.BeansException;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import tel_ran.persons.model.dao.PersonsOrm;
import tel_ran.persons.model.entities.*;

public class PersonsOrmTestCreationAppl {
static PersonsOrm personsOrm;
	public static void main(String[] args) {
		Person[] persons = { new Child(123, "Moshe", LocalDate.of(2011, 11, 24), new Address("Rehovot", "Plaut", 10), "tel-ran"),
				new Employee(124, "Vasya", LocalDate.of(1980, 1, 3), new Address("Rehovot", "Plaut", 10), "Tel-Ran", 15000),
				new Child(125, "Sara", LocalDate.of(2015, 3, 14), new Address("Rehovot", "Plaut", 10), "none"),
				new Child(126, "Olya", LocalDate.of(2010, 11, 12), new Address("Beersheva", "Yelim", 3), "Klita"),
				new Child(127, "Sasha", LocalDate.of(2012, 12, 3), new Address("Beersheva", "Yelim", 3), "Klita"),
				new Employee(128, "David", LocalDate.of(1970, 1, 3), new Address("Beersheva", "Yelim", 3), "Motorola", 20000),
				new Child(129, "Tolya", LocalDate.of(2010, 5, 5), new Address("Rehovot", "Plaut", 10), "Salut"),
				new Employee(130, "Serge", LocalDate.of(1975, 1, 12), new Address("Beersheva", "Yelim", 3), "Motorola", 18000) 
				};
		
		//Чтобы не закрывать контекст		
		try(AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");) {
			personsOrm = ctx.getBean(PersonsOrm.class);
			createPersons(persons,personsOrm);
			personsOrm.updateAddress(123, new Address("Rishon", "New Street", 10));
		} 
	}

	
	public static void createPersons(Person[] persons, PersonsOrm personsOrm) {
		for (Person person : persons){
			personsOrm.addPerson(person);
		}
		
	}

}
