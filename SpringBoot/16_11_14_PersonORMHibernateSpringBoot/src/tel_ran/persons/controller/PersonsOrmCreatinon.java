package tel_ran.persons.controller;
//пакедж в класс с контроллером
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tel_ran.persons.model.dao.PersonsOrm;
import tel_ran.persons.model.entites.*;

@Component    //чтобы перехватить управление у сервиса
public class PersonsOrmCreatinon implements CommandLineRunner {  //чтобы перехватить управление у сервиса
	@Autowired
	PersonsOrm personsOrm;

	private static void createPersons(Person[] persons, PersonsOrm personsOrm) {
		for (Person person : persons) {
			personsOrm.addPerson(person);
		}
	}

	@Override
	public void run(String... arg0) throws Exception {
		Person[] persons = {
				new Child(123, "Moshe", LocalDate.of(2011, 11, 3), new Address("Rehovot", "Plaut", 10), "tel-ran"),
				new Employee(124, "Vasya", LocalDate.of(1990, 1, 30), new Address("Rehovot", "Plaut", 10), "Tel-Ran",
						15000),
				new Child(125, "Sara", LocalDate.of(2015, 3, 13), new Address("Rehovot", "Plaut", 10), "Google"),
				new Child(126, "Olya", LocalDate.of(2010, 4, 16), new Address("BeerSheva", "Yalim", 3), "Klita"),
				new Child(127, "Sasha", LocalDate.of(2012, 5, 3), new Address("BeerSheva", "Yalim", 3), "Klita"),
				new Employee(128, "David", LocalDate.of(1970, 7, 20), new Address("BeerSheva", "Yalim", 3), "Motorola",
						20000),
				new Child(129, "Tolya", LocalDate.of(2010, 11, 3), new Address("Rehovot", "Plaut", 10), "Salut"),
				new Employee(130, "Serg", LocalDate.of(1975, 3, 3), new Address("BeerSheva", "Yalim", 3), "Motorola",
						18000) };
		createPersons(persons, personsOrm);
	}

}
