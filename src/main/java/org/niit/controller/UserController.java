/*package org.niit.controller;



import java.util.List;

import javax.servlet.http.HttpSession;



import org.niit.DAO.UserdetailsDAO;
import org.niit.model.Userdetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {
private static final Logger log=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserdetailsDAO userdetailsDAO;
	@Autowired
	Userdetails userdetails;
	@Autowired
	FriendDAO friendDAO;
	
	//for list
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public ResponseEntity<List<Userdetails>> listAllUsers(){
		log.debug("-->Calling method listAllUsers");
		List<Userdetails> user=userdetailsDAO.list();
		if(user.isEmpty()){
			return new ResponseEntity<List<Userdetails>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Userdetails>>(user,HttpStatus.OK);
		
	}
	//to create users
	@RequestMapping(value="/createusers/", method=RequestMethod.POST)
	public ResponseEntity<Userdetails> createusers(@RequestBody Userdetails userdetails){
		log.debug("-->Calling method createUsers");
		if(userdetailsDAO.get(userdetails.getUserid())==null){
			userdetailsDAO.save(userdetails);
			return new ResponseEntity<Userdetails>(userdetails,HttpStatus.OK);
		}
		log.debug("-->User already exist"+userdetails.getUserid());
		return new ResponseEntity<Userdetails>(userdetails,HttpStatus.OK);
		}

	//to get user by user id
	@RequestMapping(value="/user/{userid}",method=RequestMethod.GET)
	public ResponseEntity<Userdetails> getuser(@PathVariable("userid")String id)
	{
	log.debug("-->calling get method");
	Userdetails userdetails=userdetailsDAO.get(id);
	if(userdetails==null)
	{
		log.debug("-->User does not exist");
		userdetails = new Userdetails();
		userdetails.setErrorCode("404");
		userdetails.setErrorMessage("User not found");
		return new ResponseEntity<Userdetails>(userdetails,HttpStatus.NOT_FOUND);
	}
	log.debug("-->User exist");
	return new ResponseEntity<Userdetails>(userdetails,HttpStatus.OK);
	}
	
	//update user by user id
	@RequestMapping(value="/user/{userid}",method=RequestMethod.PUT)
	public ResponseEntity<Userdetails> updateuser(@PathVariable("userid")String id)
	{
	log.debug("-->calling update method");
	if(userdetailsDAO.get(id)==null)
	{
		log.debug("-->User does not exist");
		userdetails = new Userdetails();
		userdetails.setErrorCode("404");
		userdetails.setErrorMessage("User not found");
		return new ResponseEntity<Userdetails>(userdetails,HttpStatus.NOT_FOUND);
	}
	userdetailsDAO.update(userdetails);
	log.debug("-->User updated successfully");
	return new ResponseEntity<Userdetails>(userdetails,HttpStatus.OK);
	
}
	//delete user
	@RequestMapping(value="/user/{userid}",method=RequestMethod.DELETE)
	public ResponseEntity<Userdetails> deleteuser(@PathVariable("userid")String id)
	{
		log.debug("-->calling delete method");
		Userdetails userdetails=userdetailsDAO.get(id);
		if(userdetails==null)
		{
			log.debug("-->User does not exist");
			userdetails = new Userdetails();
			userdetails.setErrorCode("404");
			userdetails.setErrorMessage("Blog not found");
			return new ResponseEntity<Userdetails>(userdetails,HttpStatus.NOT_FOUND);
		}
		userdetailsDAO.delete(id);
		log.debug("-->User deleted successfully");
		return new ResponseEntity<Userdetails>(userdetails,HttpStatus.OK);
		}
	
	
	//authentication
	@RequestMapping(value="/user/authenticate",method=RequestMethod.POST)
	public ResponseEntity<Userdetails> authenticateuser(@RequestBody Userdetails userdetails,HttpSession session)
	{
		log.debug("-->calling authenticate method");
		userdetails=userdetailsDAO.authenticate(userdetails.getUserid(), userdetails.getPassword());
		if(userdetails==null)
		{
			log.debug("-->User does not exist");
			userdetails = new Userdetails();
	}
		else
		{
			userdetails.setErrorCode("200");
			log.debug("-->User exist with above credentials");
			session.setAttribute("loggegInUser",userdetails);
			session.setAttribute("loggedInUserId", userdetails.getUserid());
			friendDAO.setOnLine(userdetails.getUserid());
			userdetailsDAO.setOnLine(userdetails.getUserid());
		}
		return new ResponseEntity<Userdetails>(userdetails,HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/logout/",method=RequestMethod.POST)
	public ResponseEntity<Userdetails> logout(HttpSession session)
	{
		userdetails= userdetailsDAO.authenticate(userdetails.getUserid(), userdetails.getPassword());
		friendDAO.setOffLine(userdetails.getUserid());
		userdetailsDAO.setOffLine(userdetails.getUserid());
		session.invalidate();
		return new ResponseEntity<Userdetails>(userdetails,HttpStatus.OK);
	}



		
			}
	
	
*/
package org.niit.controller;

import java.util.List;

import org.niit.DAO.UserdetailsDAO;
import org.niit.model.Userdetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;






@RestController
public class UserController {
	private static final Logger log=LoggerFactory.getLogger(UserController.class);
@Autowired
UserdetailsDAO userdetailsDAO;
@Autowired
Userdetails userdetails;
//for list
@RequestMapping(value="/user",method = RequestMethod.GET)
public ResponseEntity<List<Userdetails>> listAllUsers(){
	log.debug("-->Calling method listAllUsers");
	List <Userdetails> users=userdetailsDAO.list();


	if(users.isEmpty())
	{
		return new ResponseEntity<List<Userdetails>>(HttpStatus.NO_CONTENT);
	}
		return new ResponseEntity<List<Userdetails>>(users,HttpStatus.OK);
}
/*@RequestMapping(value="/users", method=RequestMethod.GET)
public ResponseEntity<List<Userdetails>> listAllUsers(){
	log.debug("-->Calling method listAllUsers");
	List<Userdetails> user=userdetailsDAO.list();
	if(user.isEmpty()){
		return new ResponseEntity<List<Userdetails>>(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<List<Userdetails>>(user,HttpStatus.OK);
	
}
*/
//to create users
@RequestMapping(value="/",method = RequestMethod.POST)
public ResponseEntity<List<Userdetails>> createUser(@RequestBody Userdetails userdetails)
{
	log.debug("->->->Calling method authenticate");
	
	if(userdetailsDAO.get(userdetails.getUserid())==null)
	{
		userdetailsDAO.save(userdetails);
		return new ResponseEntity<List<Userdetails>>(HttpStatus.OK);	
	}
	else
	{
		log.debug("-->User already exist"+userdetails.getUserid());

	}
	userdetails.setErrorMessage("user does not exist with this id:" +userdetails.getUserid());
	return new ResponseEntity<List<Userdetails>>(HttpStatus.OK);	
		
}
/*@RequestMapping(value="/user/{userid}",method = RequestMethod.GET)
public ResponseEntity<List<User>> getUser(@PathVariable ("userid") String id)
{
	User user = userDAO.get(id);
	{
	if(user==null)
	{
		user =new User();
		user.setErrorCode("404");
		user.setErrorMessage("user does not exist with this id:" +user.getUserid());
		return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);	
	}
	return new ResponseEntity<List<User>>(HttpStatus.OK);
	}
	log.debug("-->User exist");
	return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	*/
	
@RequestMapping(value="/user/{userid}",method=RequestMethod.GET)
public ResponseEntity<Userdetails> getuser(@PathVariable("userid")String id)
{
log.debug("-->calling get method");
Userdetails userdetails=userdetailsDAO.get(id);
if(userdetails==null)
{
	log.debug("-->User does not exist");
	userdetails = new Userdetails();
	userdetails.setErrorCode("404");
	userdetails.setErrorMessage("User not found");
	return new ResponseEntity<Userdetails>(userdetails,HttpStatus.NOT_FOUND);
}
log.debug("-->User exist");
return new ResponseEntity<Userdetails>(userdetails,HttpStatus.OK);
}



//update user by userid
@RequestMapping(value="/user/{userid}",method = RequestMethod.PUT)
public ResponseEntity<List<Userdetails>> updateUser(@PathVariable ("userid") String id, @RequestBody Userdetails userdetails) 
{
	log.debug("-->calling update method");

	if(userdetailsDAO.get(userdetails.getUserid())==null)
	{
		log.debug("-->User does not exist");
		userdetails =new Userdetails();
		userdetails.setErrorMessage("user does not exist with this id:" +userdetails.getUserid());
		return new ResponseEntity<List<Userdetails>>(HttpStatus.NOT_FOUND);	
	
	
	}
	userdetailsDAO.update(userdetails);
	log.debug("-->User updated successfully");
	return new ResponseEntity<List<Userdetails>>(HttpStatus.OK);
}

@RequestMapping(value="/",method = RequestMethod.DELETE)
public ResponseEntity<List<Userdetails>> updateUser(@PathVariable ("userid") String id) 
{log.debug("-->calling delete method");
	Userdetails userdetails = userdetailsDAO.get(id);
	{
	if(userdetails==null)
	{log.debug("-->User does not exist");
	
		userdetails =new Userdetails();	
		userdetails.setErrorMessage("user does not exist with this id:" +userdetails.getUserid());
		return new ResponseEntity<List<Userdetails>>(HttpStatus.NOT_FOUND);	
	
	
	}
	userdetailsDAO.delete(id);
	log.debug("-->User deleted successfully");
	
	return new ResponseEntity<List<Userdetails>>(HttpStatus.OK);
}

}

/*@RequestMapping(value="/user/{userid}",method = RequestMethod.GET)
public ResponseEntity<List<User>> getUser(@PathVariable ("userid") String id)
{
	User user = userDAO.get(id);
	{
	if(user==null)
	{
		user =new User();
		user.setErrorCode("404");
		user.setErrorMessage("user does not exist with this id:" +user.getUserid());
		return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);	
	}
	return new ResponseEntity<List<User>>(HttpStatus.OK);

*/	
	



}




