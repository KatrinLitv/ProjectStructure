package tel_ran.persons.tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.*;

import org.junit.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import tel_ran.persons.model.dao.PersonsOrm;
import tel_ran.persons.model.entities.Address;
import tel_ran.persons.model.entities.Child;
import tel_ran.persons.model.entities.Employee;
import tel_ran.persons.model.entities.Person;
import static tel_ran.persons.tests.PersonsOrmTestCreationAppl.*;

public class PersonsOrmTest {
private static final int ID = 112233;
private static final String CITY = "Tel-Aviv";
private static final String STREET = "Sokolov";
private static final int BLD = 10;
static Person [] persons;
static Person[] personsNov;

static AbstractApplicationContext ctx;
static PersonsOrm personsOrm;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new FileSystemXmlApplicationContext("beans.xml");
		personsOrm = ctx.getBean(PersonsOrm.class);
		
		persons = new Person [] { new Child(123, "Moshe", LocalDate.of(2011, 11, 24), new Address("Rehovot", "Plaut", 10), "tel-ran"),
				new Employee(124, "Vasya", LocalDate.of(1980, 1, 3), new Address("Rehovot", "Plaut", 10), "Tel-Ran", 15000),
				new Child(125, "Sara", LocalDate.of(2015, 3, 14), new Address("Rehovot", "Plaut", 10), "none"),
				new Child(126, "Olya", LocalDate.of(2010, 11, 12), new Address("Beersheva", "Yelim", 3), "Klita"),
				new Child(127, "Sasha", LocalDate.of(2012, 12, 3), new Address("Beersheva", "Yelim", 3), "Klita"),
				new Employee(128, "David", LocalDate.of(1970, 1, 3), new Address("Beersheva", "Yelim", 3), "Motorola", 20000),
				new Child(129, "Tolya", LocalDate.of(2010, 5, 5), new Address("Rehovot", "Plaut", 10), "Salut"),
				new Employee(130, "Serge", LocalDate.of(1975, 1, 12), new Address("Beersheva", "Yelim", 3), "Motorola", 18000) 
				};
		personsNov = new Person [] {
				new Child(123, "Moshe", LocalDate.of(2011, 11, 24), new Address("Rehovot", "Plaut", 10), "tel-ran"),
				new Child(126, "Olya", LocalDate.of(2010, 11, 12), new Address("Beersheva", "Yelim", 3), "Klita"),
				new Child(ID, "Masha", LocalDate.of(2013, 11, 1), new Address(CITY, STREET, BLD), "Shalom")
		};		
		createPersons(persons, personsOrm);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ctx.close();
	}

	@Before
	public void setUp() throws Exception {
		personsOrm.addPerson(new Child(ID, "Masha", LocalDate.of(2013, 11, 1), new Address(CITY, STREET, BLD), "Shalom"));
		
	}

	@Test
	public void testGetPerson() {
		Person person = personsOrm.getPerson(ID);
		assertEquals(CITY,person.getAddress().getCity());
	}
	
	@Test
	public void testRemovePerson() {
		Person person = personsOrm.getPerson(ID);
		assertEquals(person,personsOrm.removePerson(ID));
		assertEquals(null,personsOrm.getPerson(ID));
	}
	
	@Test
	public void testGetPersonsByMonth() {
		List<Person> actual = personsOrm.getPersonsByMonth(11);
		Person [] actualArray = actual.toArray(new Person [actual.size()]);
		Arrays.sort(actualArray,(a,b)->a.getId()-b.getId());
		Arrays.sort(personsNov,(a,b)->a.getId()-b.getId());
		assertArrayEquals(personsNov,actualArray);
	}
	
	@After
	public void tearDown(){
		//personsOrm.removePerson(ID);
	}
}
