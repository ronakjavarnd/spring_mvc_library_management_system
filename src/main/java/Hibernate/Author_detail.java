package Hibernate;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
 @Table(name = "AUTHORS")
 public class Author_detail {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbookauth")
    private Long id;
    
    private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
      System.out.println("name"+name);
		this.name = name;
	}

	@Override
	public String toString() {
		return "Author_detail [id=" + id + ", name=" + name + "]";
	}

	public Author_detail() {
		// TODO Auto-generated constructor stub
	}
    
		
}