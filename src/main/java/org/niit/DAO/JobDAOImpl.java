/*package org.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.niit.model.Job;
import org.niit.model.User;
import org.springframework.stereotype.Repository;

@Repository("jobDAO")
public class JobDAOImpl  {
	private SessionFactory sessionFactory;
	public JobDAOImpl(SessionFactory sessionFactory)
	{
	this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean postJob(Job job)
	{
	try {
		job.setId(getMaxId()+1);
		sessionFactory.getCurrentSession().save(job);
		
		
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
		return false;
	}
	
	return true;
	}
	
	
	@Transactional
	public boolean updateJob(Job jobApplication)
	{
	try {
		sessionFactory.getCurrentSession().update(jobApplication);
		
	
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
		return false;
	}
	return true;
	}
	
	@Transactional
	private Integer getMaxId()
	{

	Integer maxID = 100;
	try {
		String hql="select max(id) from job";
	
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		maxID=(Integer) query .uniqueResult();
			
	}
	catch(Exception e)
	{
		maxID = 100;
		e.printStackTrace();
	
	}
		
	return maxID+1;

	}
	@Transactional
	public boolean save(JobApplication jobApplied)
	{
	try {
		sessionFactory.getCurrentSession().save(jobApplied);
		
	
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
		return false;
	}
	return true;
	}
	@Transactional
	public List<Job> getAllVacantJobs() {
		String hql="from job where status='v'";
		
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
	
		return query.list();
	}
	@Transactional
	public boolean applyForJob(JobApplication jobApplication) {
		try{
			sessionFactory.getCurrentSession().save(jobApplication);
		}catch(Exception e)
		{
			
			e.printStackTrace();
			return false;
		}
		return true;
		}


	}
	
	
	
	
	
	
	
	
	
	


	
	
	
	

*/