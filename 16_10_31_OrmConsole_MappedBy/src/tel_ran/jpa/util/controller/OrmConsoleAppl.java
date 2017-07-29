package tel_ran.jpa.util.controller;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import tel_ran.jpa.util.dao.EntityOrm;

public class OrmConsoleAppl {
static EntityOrm entityOrm;
//Проверка обратных связей
//Select books from Author where name='author7'

//SElect a from Author a where size(books)>16
//авторы, которые написали больше 10 книг
//Select a from Book b join b.authors a group by a.name having count(a.name)>16
//тот же самый запрос без обратной связи

//Select cars from Owner where id=1
//Все машины, кот принадлежат владельцу с ид=1


public static void main(String[] args) {
	try(AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml")){
		entityOrm  = ctx.getBean(EntityOrm.class);		
		while(true){
			System.out.println("Enter jpa-query or 'exit':");
			String queryStr = getQuery();
			if ((queryStr==null) || (queryStr.equals("exit")))
				break;	
			try {
				displayRes(entityOrm.runAnyQuery(queryStr));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}		
	}
}

private static void displayRes(String[] res) {
	for (String str : res)
		System.out.println(str);	
}

private static String getQuery() {
	Scanner in = new Scanner(System.in);
	String line = in.nextLine();
	return line;
}

}
