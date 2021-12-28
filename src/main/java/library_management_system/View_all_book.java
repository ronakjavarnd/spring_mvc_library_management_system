package library_management_system;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hibernate_test.helper.FactoryProvider;

import Hibernate.Book_detail;
import Hibernate.library_add_book_main;
import Hibernate.library_update_book_main;

@Controller
public class View_all_book {
	@Transactional
	@RequestMapping(value ="/View_all_book" ,method = RequestMethod.GET)
	public ModelAndView search_book(HttpServletRequest request, HttpServletResponse response)
	{	
		
		System.out.println("inside view all controller");
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		System.out.println("inside view all controller");
		String hql = "FROM Hibernate.Book_detail";
		Query query = session.createQuery(hql);
		List<Book_detail> results = query.list();
		List bookid = new ArrayList();
//		for(int i=0;i<results.size();i++) {
//			bookid.add(results.get(i).getBook_ID());
//		}
		
		System.out.println("book1"+bookid);
		ModelAndView mv= new ModelAndView();
		mv.setViewName("View_all_book.jsp");
		mv.addObject("totalbook",results);
		tx.commit();
        session.close();
		
		return mv;
	}
	
	@RequestMapping(value="/deletebook/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id) throws NullPointerException  { 
		try {
		System.out.println("id2"+id);
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		
		String hql = "delete from Hibernate.Book_detail  where Book_ID="+id+"";
		Query query = session.createQuery(hql);
//		query.setParameter(1,id);

		int count = query.executeUpdate();
		System.out.println("count"+count);
		session.getTransaction().commit();
		session.close();
		}catch(Exception e) {
			e.getMessage();
		}
		 return "redirect:/View_all_book";    
    }   
	
	@Transactional
	@RequestMapping(value="/editbook/{id}",method = RequestMethod.GET)    
    public ModelAndView update(@PathVariable int id) throws NullPointerException  { 
		
		System.out.println("id"+id);
		
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		
		String hql = "FROM Hibernate.Book_detail p WHERE p.Book_ID= "+id+"";
		System.out.println(hql);
		Query query = session.createQuery(hql);
		List results = query.list();
		
//		List<Book_detail> s1 = (List) results.get(0);
		System.out.println("List"+results);
		
		ModelAndView mv= new ModelAndView();
		mv.setViewName("Update_book.jsp");
 		mv.addObject("updatebook",results);
		
		
		tx.commit();

		session.close();
		
		 return mv;    
    } 
	
	@Transactional
	@RequestMapping(value ="editbook/update_book" ,method = RequestMethod.GET)
	public String update_book(HttpServletRequest request, HttpServletResponse response) throws ParseException
	{	
		System.out.println("inside controller");
		String name= (request.getParameter("Name")).toString();
		String  author=(request.getParameter("Author")).toString();
		int Price= Integer.parseInt(request.getParameter("price"));			
		String  Book_edition=(request.getParameter("Book_edition")).toString();
		int pages = Integer.parseInt(request.getParameter("pages"));
		int ISBN = Integer.parseInt(request.getParameter("ISBN"));
		String  language=(request.getParameter("language")).toString();
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		String  Date_of_publish_get=(request.getParameter("date_of_publish")).toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date Date_of_publish = sdf.parse(Date_of_publish_get);
		
		Boolean avalibility= true;
		
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		
		
		
		System.out.println("value1"+name);
		System.out.println("value1"+author);
		System.out.println("value1"+Price);
		System.out.println("value1"+Book_edition);
		System.out.println("value1"+pages);
		System.out.println("value1"+ISBN);
		System.out.println("value1"+language);
		System.out.println("value1"+Date_of_publish);
		
//		String hql = "update Hibernate.Book_detail set "+" Book_name="+name+","+" Book_author="+author+","+"Book_price="+Price+","+"Book_edition="+Book_edition+","+" pages="+pages+","+" ISBN="+ISBN+","+" language="+language+","+" date_of_publish="+Date_of_publish+","+"  where Book_ID="+bookid+"";
//		Query query = session.createQuery(hql);
//		query.setParameter(1,id);
 Boolean avaliblity=true;
		library_update_book_main addbook= new library_update_book_main();
		addbook.update_db(bookid, name, author, Price, Book_edition, pages, language, Date_of_publish, avaliblity, ISBN);
		
		
		
//		int count = query.executeUpdate();
		
		tx.commit();
		
		session.close();
				
		
		 return "redirect:/View_all_book";    
	}
	
}
