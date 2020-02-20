package com.ivi.service.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivi.service.model.User;
import com.ivi.service.repository.UserRespository;

@RestController 
public class HomeController {
	
	
	@Autowired
	private MongoTemplate mongoTemplete;
	
	@Autowired
	private UserRespository userRepository;
	
	@GetMapping("/get/mongo")
	public String getMongo( HttpServletRequest req  ) {
		
		String result = "-----getMONGO";
		
		System.out.println("##[ST]##[GETMONGO ]#############################");
		
		List<User> allList = userRepository.findAll();
		System.out.println(allList.size());
		System.out.println(allList.toString());
		System.out.println("##[ED]##[GETMONGO ]#############################");
		
		return result;
	}
	
	
	@GetMapping("/set/mongo")
	public String setMongo( HttpServletRequest req  ) {
		
		String result = "-----setMONGO";
		
		System.out.println("##[ST]##[SETMONGO ]#############################");
		
		//req.getParameter("id"),
	    mongoTemplete.insert(new User( req.getParameter("name")
	    		, req.getParameter("email")));
	    
		
		System.out.println("##[ED]##[SETMONGO ]#############################");
		
		return result;
	}

}
