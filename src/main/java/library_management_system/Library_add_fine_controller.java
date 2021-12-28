package library_management_system;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hibernate_test.helper.FactoryProvider;

import Hibernate.User_detail;
import Hibernate.library_add_user_main;
import Hibernate.library_update_user_main;

@Controller
public class Library_add_fine_controller {

	@RequestMapping(value = "Pay/add_fine", method = RequestMethod.GET)
    public String submit(HttpServletRequest request, HttpServletResponse response) throws ParseException {
//        if (result.hasErrors()) {
//            return "error";
//        }
		
		System.out.println("inside controller123");
		String name= (request.getParameter("Name")).toString();
		String email=(request.getParameter("email")).toString();
		int bookid= Integer.parseInt(request.getParameter("bookid"));	
		int userid= Integer.parseInt(request.getParameter("userid"));	
		int Amount = Integer.parseInt(request.getParameter("Amount"));
		String  ISdate_get=(request.getParameter("ISdate")).toString();
		String  REdate_get=(request.getParameter("REdate")).toString();
		String Paydate=(request.getParameter("Paydate")).toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date ISdate_get1 = sdf.parse(ISdate_get);
		Date REdate_get1 = sdf.parse(REdate_get);
		Date Paydate1=sdf.parse(Paydate);
		Boolean avalibility= true;
		
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		
		
//		
//		System.out.println("value1"+name);
//		
//		String hql = "update Hibernate.Book_detail set "+" Book_name="+name+","+" Book_author="+author+","+"Book_price="+Price+","+"Book_edition="+Book_edition+","+" pages="+pages+","+" ISBN="+ISBN+","+" language="+language+","+" date_of_publish="+Date_of_publish+","+"  where Book_ID="+bookid+"";
//		Query query = session.createQuery(hql);
//		query.setParameter(1,id);
        Boolean avaliblity=true;
		library_update_user_main addbook= new library_update_user_main();
		addbook.update_fine(bookid, name, email, ISdate_get1, REdate_get1, userid,Paydate1,Amount);
//		
//		
//		
////		int count = query.executeUpdate();
//		
//		tx.commit();
//		
//		session.close();
//				
//		
		 return "redirect:/View_all_user";    
	        
       }
}
	
	

