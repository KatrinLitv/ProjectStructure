package tel_ran.persons.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import tel_ran.persons.model.entites.Person;

public class PersonsQueryTestAppl {

	public static void main(String[] args) {
		AbstractApplicationContext cxt = new FileSystemXmlApplicationContext("beans.xml");
		

	}

	private static void displayPersons(Iterable<Person> persons) {
		for (Person person: persons){
			System.out.println(person);
		}
		
	}

}
