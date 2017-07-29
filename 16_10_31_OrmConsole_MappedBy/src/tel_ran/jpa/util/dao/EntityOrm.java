package tel_ran.jpa.util.dao;

import javax.persistence.*;
import java.util.*;
//utility which allows to create any requests to database
public class EntityOrm {
@PersistenceContext(unitName="springHibernate", type = PersistenceContextType.EXTENDED)
EntityManager em;

@SuppressWarnings("unchecked")
public String[] runAnyQuery(String queryStr){
	Query query = em.createQuery(queryStr);
	List listRes = query.getResultList();
	if ((listRes==null)||(listRes.isEmpty()))
		return new String[0];	
	String [] res;	
	if (listRes.get(0).getClass().isArray())
		res = stringFromArray(listRes);
	else res = stringFromObject(listRes);
	return res;		
}

private String[] stringFromObject(List<Object> listRes) {
	String [] res = new String[listRes.size()];	
	int i=0;
	for (Object obj : listRes){
		res[i] = obj.toString();
		i++; 
	}
	return res;
}

private String[] stringFromArray(List<Object []> listRes) {
	String [] res = new String[listRes.size()];	
	int i=0;
	for (Object obj[] : listRes){
		res[i] = Arrays.deepToString(obj);
		i++; 
	}
	return res;
}
}
