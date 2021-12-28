package library_management_system;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Hibernate.User_detail;
import Hibernate.library_add_book_main;
import Hibernate.library_add_user_main;

@Controller
public class User_controller {
	

		
	
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public ModelAndView showForm(HttpServletRequest request, HttpServletResponse response) {
    	System.out.println("inside controller");
    	ModelAndView mv = new ModelAndView();
    	mv.addObject("employee", new User_detail());
    	mv.setViewName("User_details.jsp");
		
		return mv;

    }

	@RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("employee")User_detail employee, 
      BindingResult result, ModelMap model) {
//        if (result.hasErrors()) {
//            return "error";
//        }
		System.out.println("employee"+employee.getBook1_issue());
    	library_add_user_main ud = new library_add_user_main(); 

        ud.add_user(employee.getName(),employee.getEmail(),employee.getBook1_ID(),employee.getBook1_issue(),employee.getBook1_return());
        
        System.out.println("inside add user controller ");
         
        
        return "redirect:/View_all_user";
    }
}