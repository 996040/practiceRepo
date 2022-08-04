package com.zensar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entities.Address;
import com.zensar.entities.Details;

public interface DetailsRepository extends JpaRepository<Details, Integer> {

	List<Details> findByCityName(String cityName);

	List<Details> findByEmployeeIdAndCityName(int employeeId, String cityName);
	
	List<Details> findByEmployeeName(String employeeName);
	
	List<Details> findByEmployeeNameAndCityName(String employeeName,String cityName);
	

}
