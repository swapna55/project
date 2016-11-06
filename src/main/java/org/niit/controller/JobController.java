/*package org.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.niit.DAO.JobDAO;
import org.niit.model.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {
	private static final Logger logger=LoggerFactory.getLogger(JobController.class);
	@Autowired
	JobDAO jobDAO;
	@Autowired
	Job job;
	@Autowired
	JobApplication jobApplication;
	
    @CrossOrigin(origins = "http/:localhost:8080")
	@RequestMapping(value="/getAllJobs",method = RequestMethod.GET)
	public ResponseEntity<List<Job>> getAllJobs(){
		logger.debug("calling method getAllOpenedJobs");
		List <Job> jobs=JobDAO.getAllJobs();
		return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
    }
    
    @RequestMapping(value="/getMyAppliedJobs",method = RequestMethod.GET)
	public ResponseEntity<List<Job>> getMyAppliedJobs(HttpSession httpSession){
		logger.debug("calling method getAllOpenedJobs");
		String loggedInjobId =(String) httpSession.getAttribute(loggedInjobId);
		List <Job> jobs=JobDAO.getMyAppliedJobs();
		return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
    }
    @RequestMapping(value="/getJobdetails",method = RequestMethod.GET)
   	public ResponseEntity<List<Job>> getJobdetails(HttpSession httpSession){
   		logger.debug("calling method getAllOpenedJobs");
   		
   		List <Job> jobs=JobDAO.getJobdetails();
   		return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
       }

    @RequestMapping(value="/postAJob",method = RequestMethod.POST)
    public ResponseEntity<Job> postAJob( @RequestBody Job job) 
    {
    	job.setStatus('V');
    	if(jobDAO.save(job)==false)
    	{
    		job.setErrorCode("job does not exist with this id:" +job.getId());
    		job.setErrorMessage("job does not exist with this id:" +job.getId());
    	 	logger.debug("not able to postAjob");
    		
    	
    	
    	}
   
    return new ResponseEntity<Job>(job,HttpStatus.OK);
    }
    @RequestMapping(value="/selectUser/{Userid}/{Jobid}",method = RequestMethod.PUT)
    public ResponseEntity<Job>selectUser(@RequestParam("userID") String userID,@RequestParam("jobID") String jobID) 
    {
    	jobApplication.setStatus('S');
    	if(jobDAO.save(jobApplication))
    	{
    		job.setErrorCode("404");
    		job.setErrorMessage("Not able to change the job application status 'Call For Interview'");
    	 	logger.debug("Not able to change the job application status 'Call For Interview'");
    		
    	
    	
    	}
    }

    @RequestMapping(value="/canCallForInterview/{Userid}/{Jobid}",method = RequestMethod.PUT)
    public ResponseEntity<Job>canCallForInterview(@RequestParam("userID") String userID,@RequestParam("jobID")String jobID ) 
    {
    	jobApplication.setStatus('C');
    	if(jobDAO.save(jobApplication))
    	{
    		job.setErrorCode("404");
    		job.setErrorMessage("Not able to change the job application status 'Call For Interview'");
    	 	logger.debug("Not able to change the job application status 'Call For Interview'");
    		
    	
    	
    	}
   
    return new ResponseEntity<Job>(job,HttpStatus.OK);
    }
    @RequestMapping(value="/rejectJobApplication/{Userid}/{Jobid}",method = RequestMethod.PUT)
    public ResponseEntity<Job>rejectJobApplication(@RequestParam("userID") String userID,@RequestParam("jobID")String jobID){ 
    
    	jobApplication.setStatus('R');
    	if(jobDAO.save(jobApplication))
    	{
    		job.setErrorCode("404");
    		job.setErrorMessage("Not able to reject the application");
    	 	logger.debug("Not able to reject the application ");
    		
    	
    	
    	}
   
    return new ResponseEntity<Job>(job,HttpStatus.OK);
    }









		if(jobs.isEmpty())
			
		{
			logger.debug("No Jobs are available");
			return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);
		}
			return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
	}


}
*/