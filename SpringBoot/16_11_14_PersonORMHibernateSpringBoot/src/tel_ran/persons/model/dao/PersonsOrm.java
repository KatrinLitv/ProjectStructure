package tel_ran.persons.model.dao;
import java.util.List;

import javax.persistence.*;

import org.springframework.transaction.annotation.Transactional;

import tel_ran.persons.model.entites.*;

public class PersonsOrm {
	
	@PersistenceContext(unitName="springHibernate")
	EntityManager em;
	
	@Transactional
	public boolean addPerson(Person person){
		if(person != null){
		if (em.find(Person.class, person.getId())!=null)
			return false;
		em.persist(person);
		    return true;
		}
		return false;
	}
	
	@Transactional
	public boolean updateAddress(int id, Address address){
		Person person = em.find(Person.class, id);
		if (person==null)
			return false;
		person.setAddress(address);
		return true;
	}
	
	public Person getPerson (int id){
		return em.find(Person.class, id);
	}
	
	@Transactional
	public Person removePerson (int id){
		Person res = em.find(Person.class, id);
		if (em!=null) em.remove(res);
		
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List <Person> getPersondByMonth (int month){
		Query query = em.createNamedQuery
				(String.format("select p from Person p where month (p.birthdate=%d", month));
		return query.getResultList();
		
	}
	
}
