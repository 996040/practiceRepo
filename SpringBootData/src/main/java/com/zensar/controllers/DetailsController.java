package com.zensar.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entities.Address;
import com.zensar.entities.BaseResponse;
import com.zensar.entities.Details;
import com.zensar.services.DetailsService;
import com.zensar.status.Status;

@RestController
public class DetailsController {

	@Autowired
	private DetailsService detailsService;

	@GetMapping("/stat")
	public List<Status> getStatus() {
		List<Status> status = new ArrayList<>();
		ArrayList<Details> details = new ArrayList<Details>();
		Address address = new Address(20, "Mumbai Streat", "Pune", "India", 423301);
		details.add(new Details(20, "Neeraj", "neeraj@gmail.com", "Pune", 77654433, address));
//		status.add(new Status("status", 1, "Request successfully processed", details));
		return status;
	}

	@GetMapping("/employee/{employeeId}")
	public BaseResponse getDetails(@PathVariable("employeeId") int employeeId) {
		BaseResponse baseResponse = new BaseResponse();
		Status status = new Status();
		Details details = detailsService.getDetails(employeeId);
		status.setStatusCode(200);
		status.setStatusMessage("Details with The available Id");
		baseResponse.setDetails(details);
		baseResponse.setStatus(status);
		return baseResponse;
//		return detailsService.getDetails(employeeId);
	}

	@GetMapping("/employee")
	public List<Details> getAllDetails() {
		BaseResponse baseResponse = new BaseResponse();
		Status status = new Status();
		List<Details> details = detailsService.getAllDetails();
		status.setStatusCode(200);
		status.setStatusMessage("All Employee Details");
		baseResponse.setStatus(status);
		return details;
//		return detailsService.getAllDetails();
	}

	@PostMapping("/employee")
	public BaseResponse insertDetails(@RequestBody @Valid Details employee) {
		BaseResponse baseResponse = new BaseResponse();
		Status status = new Status();
		Details details = detailsService.insertDetails(employee);
		status.setStatusCode(200);
		status.setStatusMessage("Details Added Successfully...");
		baseResponse.setDetails(employee);
		baseResponse.setStatus(status);
		return baseResponse;
//		return detailsService.insertDetails(employee);
	}

	@PutMapping("/employee")
	public BaseResponse updateDetails(@RequestBody @Valid Details employee) {
//		System.out.println("New Employee Id" + employeeId);
		System.out.println("Detail Employee" + employee.getEmployeeId());
		detailsService.updateDetails(employee);
		BaseResponse baseResponse = new BaseResponse();
		Status status = new Status();
		status.setStatusCode(201);
		status.setStatusMessage("Details Updated Successfully!!!");
		baseResponse.setDetails(employee);
		baseResponse.setStatus(status);
		return baseResponse;

//		return new ResponseEntity<String>("Details Updated Successfully!!!", HttpStatus.OK);
	}

	@DeleteMapping("/employee/{employeeId}")
	public BaseResponse deleteDetails(@PathVariable("employeeId") int employeeId) {
		detailsService.deleteDetails(employeeId);
		BaseResponse baseResponse = new BaseResponse();
		Status status = new Status();
		status.setStatusCode(200);
		status.setStatusMessage("Successfully Deleted...");
		baseResponse.setStatus(status);
		return baseResponse;
//		return new ResponseEntity<>("Details Deleted Successfully!!!", HttpStatus.OK);
	}

	@GetMapping("/employee/cityName/{cityName}")
	public List<Details> findByCityName(@PathVariable("cityName") String cityName) {
		BaseResponse baseRespone = new BaseResponse();
		Status status = new Status();
		Details details = new Details();
		status.setStatusCode(200);
		status.setStatusMessage("Details with the Comman cityName");
		baseRespone.setStatus(status);
		baseRespone.setDetails(details);
//		return baseRespone;
		return detailsService.findByCityName(cityName);
	}

	@GetMapping("/employee/{employeeId}/{cityName}")
	public List<Details> findByEmployeeIdAndCityName(@PathVariable("employeeId") int employeeId,
			@PathVariable("cityName") String cityName) {
		return detailsService.findByEmployeeIdAndCityName(employeeId, cityName);
	}

	@GetMapping("/employee/employeeName/{employeeName}")
	public List<Details> findByEmployeeNameAndCityName(@PathVariable("employeeName") String employeeName) {
		return detailsService.findByEmployeeName(employeeName);
	}

	@GetMapping("/employee/employeeName/cityName/{employeeName}/{cityName}")
	public List<Details> findByEmployeeNameAndCityName(@PathVariable("employeeName") String employeeName,
			@PathVariable("cityName") String cityName) {
		return detailsService.findByEmployeeNameAndCityName(employeeName, cityName);
	}

//	@ExceptionHandler(value = NoSuchDetailsExistsException.class)
//	@ResponseStatus(HttpStatus.CONFLICT)
//	public ErrorResponse handleNoSuchDetailsExistsException(NoSuchDetailsExistsException exception) {
//		return new ErrorResponse(HttpStatus.CONFLICT.value(), exception.getMessage());
//	}

}
