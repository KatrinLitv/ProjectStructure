package tel_ran.persons.client;

import java.util.*;

import org.springframework.web.client.RestTemplate;
import static tel_ran.persons.api.PersonsConstants.*;
import tel_ran.persons.client.api.*;

public class PersonsOrmClient {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		final String URL="http://localhost:8080/";
		EmployeeData employee = 
				new EmployeeData(1234, "Lior", new Date(), "Rehovot", "Plaut", 10, "Tel-ran", 10000);
		ChildData child = 
				new ChildData(1244, "Avital", new Date(), "Beer-Sheva", "Yaalim", 3, "Ofarim");
		String res = restTemplate.postForObject(URL+ADD_PERSON, employee, String.class);
		String res1 = restTemplate.postForObject(URL+ADD_PERSON, child, String.class);
		System.out.println(res);
		System.out.println(res1);
	}

}
