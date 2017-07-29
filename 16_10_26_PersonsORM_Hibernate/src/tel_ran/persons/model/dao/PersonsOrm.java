package tel_ran.persons.model.dao;

import java.util.*;

import javax.persistence.*;
import org.springframework.transaction.annotation.Transactional;

import tel_ran.persons.model.entities.*;

public class PersonsOrm {
@PersistenceContext(unitName="springHibernate")
EntityManager em;

@Transactional
public boolean addPerson(Person person){
	if ((person==null)||(em.find(Person.class, person.getId())!=null))
		return false;
	em.persist(person);
	return true;
}

@Transactional
public boolean updateAddress(int id, Address newAddress){
	//кладем персона в персистенс контекст
	Person person = em.find(Person.class, id);
	if(person==null)
		return false;
	person.setAddress(newAddress);
	return true;
}

public Person getPerson(int id){
	return em.find(Person.class, id);
}

@Transactional
public Person removePerson(int id){
	Person res = em.find(Person.class,id);
	if (res!= null)
		em.remove(res);
	return res;
}

@SuppressWarnings("unchecked")
public List<Person> getPersonsByMonth(int month){
//	Query query = em.createQuery(String.format("Select p from Person p" +
//			" where month(p.birthDate)=%d", month));
	
//	Query query = em.createQuery("Select p from Person p" +
//			" where month(p.birthDate)=?1");
//	query.setParameter(1, month);
//	return query.getResultList();
	
	return em.createQuery("Select p from Person p" +
			" where month(p.birthDate)=?1").setParameter(1, month).getResultList();
}
}
