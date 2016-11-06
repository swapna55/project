package org.niit.Test;
import org.niit.DAO.UserdetailsDAO;
import org.niit.model.Userdetails;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTest {
	public static void main(String[] args){
		 AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		 
	context.scan("org.niit.*");
	context.refresh();
	
	UserdetailsDAO userdetailsDAO=(UserdetailsDAO) context.getBean("userdetailsDAO");
	Userdetails userdetails=(Userdetails) context.getBean("userdetails");
	userdetails.setUserid("user002");
	userdetails.setUsername("Ram1");
	userdetails.setEmail("ram1@gmail.com");
	userdetails.setContact("7491581209");
	userdetails.setAddress("Triiichy");
	userdetails.setPassword("ramkkkumar");
	userdetails.setRole("ROLE_STUDENT1");
	
	if(userdetailsDAO.save(userdetails) == true)
	{
    System.out.println("category created successfully");
	}
	else
	{
		System.out.println("not able to create category");
	}
	}




}
