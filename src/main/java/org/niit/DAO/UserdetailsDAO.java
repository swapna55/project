package org.niit.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;


import org.niit.model.Userdetails;



@Repository
public interface UserdetailsDAO {
	
	public boolean save(Userdetails userdetails);
	
	public boolean update(Userdetails userdetails);
		
		public boolean delete(String id);
		
		public void setOnLine(String userid);
		public void setOffLine(String userid);
		public List<Userdetails> list();
				
		public Userdetails authenticate(String username, String password);
		
		public Userdetails get(String username);
		

	
			

}
