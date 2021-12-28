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
import Hibernate.User_detail;
import Hibernate.library_add_book_main;
import Hibernate.library_update_book_main;
import Hibernate.library_update_user_main;

@Controller
public class View_all_user {
	@Transactional
	@RequestMapping(value ="/View_all_user" ,method = RequestMethod.GET)
	public ModelAndView search_user(HttpServletRequest request, HttpServletResponse response)
	{	
		
		System.out.println("inside view all controller");
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		System.out.println("inside view all controller");
		String hql = "FROM Hibernate.User_detail";
		Query query = session.createQuery(hql);
		List<User_detail> results = query.list();
		List bookid = new ArrayList();
//		for(int i=0;i<results.size();i++) {
//			bookid.add(results.get(i).getBook_ID());
//		}
		
		System.out.println("bookRESULT"+results);
		ModelAndView mv= new ModelAndView();
		mv.setViewName("View_all_user.jsp");
		mv.addObject("totaluser",results);
		tx.commit();
        session.close();
		
		return mv;
	}
	
	@RequestMapping(value="/deleteuser/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id) throws NullPointerException  { 
		try {
		System.out.println("id2"+id);
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		
		String hql = "delete from Hibernate.User_detail  where id="+id+"";
		Query query = session.createQuery(hql);
//		query.setParameter(1,id);

		int count = query.executeUpdate();
		System.out.println("count"+count);
		session.getTransaction().commit();
		session.close();
		}catch(Exception e) {
			e.getMessage();
		}
		 return "redirect:/View_all_user";    
    }   
	
	@Transactional
	@RequestMapping(value="/edituser/{id}",method = RequestMethod.GET)    
    public ModelAndView update(@PathVariable int id) throws NullPointerException  { 
		
		System.out.println("id"+id);
		
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		
		String hql = "FROM Hibernate.User_detail p WHERE p.id= "+id+"";
		System.out.println(hql);
		Query query = session.createQuery(hql);
		List results = query.list();
		
//		List<Book_detail> s1 = (List) results.get(0);
		System.out.println("List"+results);
		
		ModelAndView mv= new ModelAndView();
		mv.setViewName("Update_user.jsp");
 		mv.addObject("updateuser",results);
		
		
		tx.commit();

		session.close();
		
		 return mv;    
    } 
	
	@Transactional
	@RequestMapping(value ="edituser/update_user" ,method = RequestMethod.GET)
	public String update_book(HttpServletRequest request, HttpServletResponse response) throws ParseException
	{	
		System.out.println("inside controller");
		String name= (request.getParameter("Name")).toString();
		String email=(request.getParameter("email")).toString();
		int bookid= Integer.parseInt(request.getParameter("bookid"));	
		int userid= Integer.parseInt(request.getParameter("userid"));	
		
		String  ISdate_get=(request.getParameter("ISdate")).toString();
		String  REdate_get=(request.getParameter("REdate")).toString();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date ISdate_get1 = sdf.parse(ISdate_get);
		Date REdate_get1 = sdf.parse(REdate_get);
		Boolean avalibility= true;
		
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		
		
		
		System.out.println("value1"+name);
		
//		String hql = "update Hibernate.Book_detail set "+" Book_name="+name+","+" Book_author="+author+","+"Book_price="+Price+","+"Book_edition="+Book_edition+","+" pages="+pages+","+" ISBN="+ISBN+","+" language="+language+","+" date_of_publish="+Date_of_publish+","+"  where Book_ID="+bookid+"";
//		Query query = session.createQuery(hql);
//		query.setParameter(1,id);
        Boolean avaliblity=true;
		library_update_user_main addbook= new library_update_user_main();
		addbook.update_db(bookid, name, email, ISdate_get1, REdate_get1, userid);
		
		
		
//		int count = query.executeUpdate();
		
		tx.commit();
		
		session.close();
				
		
		 return "redirect:/View_all_user";    
	}

	@RequestMapping(value="/Pay/{id}",method = RequestMethod.GET)    
    public ModelAndView Pay(@PathVariable int id) throws NullPointerException  { 
		
		System.out.println("id2"+id);
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		

		String hql = "FROM User_detail p WHERE p.id= "+id+"";

		
		Query query = session.createQuery(hql);
		List<User_detail> results = query.list();

		//		query.setParameter(1,id);

//		int count = query.executeUpdate();
//		System.out.println("count"+count);
//		session.getTransaction().commit();
//		tx.commit();

		
		session.close();
		
		ModelAndView mv= new ModelAndView();
		mv.setViewName("Pay_user.jsp");
 		mv.addObject("payuser",results);
		
		
		
		
		 return mv;    
    
    }   

	
	
}
