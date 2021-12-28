package Hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

public class library_add_user_main {

	
	
	public void add_user(String name,String email, int book_id,Date Book1_issue,Date Book1_return) {
	System.out.println("inside Book1_return"+Book1_return);
	User_detail ud =  new User_detail();
    Pay_detail pd = new Pay_detail();
	ud.setName(name);
	ud.setBook1_ID(book_id);
	ud.setEmail(email);
	ud.setBook1_issue(Book1_issue);
    ud.setBook1_return(Book1_return);
    pd.setAmount(0);
    ud.setAuthor_details(pd);
   
   	
	
	SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionfactory.openSession();
	session.beginTransaction();
	session.save(ud);

	session.getTransaction().commit();
	session.close();
    ud= null;
	}

	
	
	
}
