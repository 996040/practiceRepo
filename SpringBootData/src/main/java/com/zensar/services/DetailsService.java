package com.zensar.services;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.zensar.dto.DetailsDto;
import com.zensar.entities.Address;
import com.zensar.entities.Details;

public interface DetailsService {
	

	public Details getDetails(int employeeId);

	public List<Details> getAllDetails();

	public List<Details> getAllDetails(int employeeId, Details cityName);

	public Details insertDetails(Details employee);

	public void updateDetails(Details employee);

	public void deleteDetails(int employeeId);

	List<Details> findByCityName(String cityName);
	
	List<Details> findByEmployeeIdAndCityName(int employeeId, String cityName);
	
	List<Details> findByEmployeeName(String employeeName);
	
	List<Details> findByEmployeeNameAndCityName(String employeeName,String cityName);
	

}
