package Hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class library_update_user_main {

	public void update_db(int bookid,String name, String email, Date ISdate_get1,Date REdate_get1, int userid)
	{
//	System.out.println("Author"+Author);
	User_detail ud = new 	User_detail();
//	Author_detail ad = new Author_detail();

	ud.setBook1_ID(bookid);
	ud.setBook1_issue(ISdate_get1);
	ud.setBook1_return(REdate_get1);
	ud.setEmail(email);
	ud.setId(userid);
	ud.setName(name);
	
	SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionfactory.openSession();
	session.beginTransaction();
	
	session.update(ud);
	session.getTransaction().commit();
	session.close();
    ud= null;

	}	

	public void update_fine(int bookid,String name, String email, Date ISdate_get1,Date REdate_get1, int userid,Date Paydate1,int Amount)
	{
//	System.out.println("Author"+Author);
	User_detail ud = new 	User_detail();
//	Author_detail ad = new Author_detail();
    Pay_detail pd = new Pay_detail();
	ud.setBook1_ID(bookid);
	ud.setBook1_issue(ISdate_get1);
	ud.setBook1_return(REdate_get1);
	ud.setEmail(email);
	ud.setId(userid);
	ud.setName(name);
	
	pd.setAmount(Amount);
	pd.setPaymentDate(Paydate1);
	ud.setAuthor_details(pd);
    
	SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionfactory.openSession();
	session.beginTransaction();
	
	session.update(ud);
	
	session.getTransaction().commit();
	session.close();
    ud= null;

	}	

	
}
