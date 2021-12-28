package Hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

public class library_add_book_main {

	@Autowired
	Book_detail book;
	
	@Autowired
	Author_detail ad;
	
	public void add_db(String name, String Author, int Price,String Book_edition, int pages,String language,Date date_of_publish,Boolean avaliblity,int isbn)
	{
	System.out.println("inside class"+name);
	Book_detail book = new Book_detail();
	book.setBook_name(name);
	Author_detail ad = new 	Author_detail();
	ad.setName(Author); 
	book.setAuthor_details(ad);
	book.setBook_price(Price);
	book.setBook_edition(Book_edition);
	book.setPages(pages);
	book.setLanguage(language);
	book.setDate_of_publish(date_of_publish);
	book.setAvailability(avaliblity);
	book.setISBN(isbn);
	
	SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionfactory.openSession();
	session.beginTransaction();
	session.save(ad);
	session.save(book);

	session.getTransaction().commit();
	session.close();
    book= null;
	}
}
