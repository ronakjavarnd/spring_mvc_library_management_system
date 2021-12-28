package Hibernate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="User_detail")
public class User_detail implements Serializable{
	
	@Id
	@GeneratedValue
	int id;
	String name;
	String email;
	int Book1_ID;
	
	@ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "fine_details",referencedColumnName = "idbookpay")
    private Pay_detail fine_details;
	
	
	
	

	
    @DateTimeFormat(pattern = "dd/MM/yyyy")
	Date Book1_issue;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
	Date Book1_return;

    
    
    
	public Pay_detail getAuthor_details() {
		return fine_details;
	}
	public void setAuthor_details(Pay_detail fine_details) {
		this.fine_details = fine_details;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBook1_ID() {
		return Book1_ID;
	}
	public void setBook1_ID(int book1_ID) {
		Book1_ID = book1_ID;
	}
	public Date getBook1_issue() {
		return Book1_issue;
	}
	
	
	public void setBook1_issue(Date book1_issue) {
		Book1_issue = book1_issue;
	}
	
	
	
	public Date getBook1_return() {
		return Book1_return;
	}
	public void setBook1_return(Date book1_return) {
		Book1_return = book1_return;
	}
	public User_detail(int id, String name, String email, int book1_ID, Date book1_issue,Date book1_return) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		Book1_ID = book1_ID;
		Book1_issue = book1_issue;
		Book1_return = book1_return;
	}
	public User_detail() {
		// TODO Auto-generated constructor stub
	}
	
   
}
