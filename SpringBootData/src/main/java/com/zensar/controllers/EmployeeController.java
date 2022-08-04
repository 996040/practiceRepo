 package com.zensar.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entities.Details;
import com.zensar.repository.DetailsRepository;
import com.zensar.status.Status;

@RestController
public class EmployeeController {

	@Autowired
	private DetailsRepository detailsRepository;



//	private List<Details> details = new ArrayList<Details>();
//
//	public EmployeeController() {
//		details.add(new Details(46186, "Ashish"));
//		details.add(new Details(46187, "Priyesh"));
//		details.add(new Details(67162, "Neeraj"));
//		details.add(new Details(67176, "Anil"));
//	}
//
//	@GetMapping("/data")
//	public List<Details> getAllEmployees() {
//		return details;
//	}
	
	

	@GetMapping("/status")
	public List<Status> getStatus() {
//	public List<Details> getDetails() {	

		List<Status> status = new ArrayList<>();
		ArrayList<Details> details = new ArrayList<Details>();
		
		details.add(new Details(20,"Neeraj","neeraj@gmail.com","Pune", 77654433));


//		status.add(new Status("status", 1, "Request successfully processed", details));
//		return detailsRepository.findAll();
		return status;
//		return statusRepository.findAll();
	}


}
