package Hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

public class library_update_book_main {

//	@Autowired
//	Book_detail book;
//	
//	@Autowired
//	Author_detail ad;
//	
	public void update_db(int bookid,String name, String Author, int Price,String Book_edition, int pages,String language,Date date_of_publish,Boolean avaliblity,int isbn)
	{
	System.out.println("Author"+Author);
	Book_detail book = new 	Book_detail();
	Author_detail ad = new Author_detail();

	book.setBook_ID(bookid);
	book.setBook_name(name);
	ad.setName(Author);
	book.setAuthor_details(ad);
	System.out.println("Author2"+Author);
	
	book.setBook_price(Price);
	book.setBook_edition(Book_edition);
	book.setPages(pages);
	book.setLanguage(language);
	book.setDate_of_publish(date_of_publish);
	book.setAvailability(avaliblity);
	book.setISBN(isbn);
	System.out.println("book"+book.getAuthor_details());
	SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionfactory.openSession();
	session.beginTransaction();
	
	session.update(book);
	session.getTransaction().commit();
	session.close();
    book= null;
	}
	
	
}
