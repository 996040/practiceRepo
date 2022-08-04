package com.zensar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zensar.entities.Details;
import com.zensar.repository.DetailsRepository;

@Service
public class DetailsServiceImpl implements DetailsService {

	@Autowired
	private DetailsRepository detailsRepository;

//	@Autowired
//	private AddressRepository addressRepository;

	@Override
	public Details getDetails(int employeeId) {
		return detailsRepository.findById(employeeId).get();
	}

	@Override
	public List<Details> getAllDetails() {
		return detailsRepository.findAll();
	}

	@Override
	public Details insertDetails(Details employee) {
		// TODO Auto-generated method stub
		return detailsRepository.save(employee);
	}

	@Override
	public void updateDetails(Details employee) {
		// TODO Auto-generated method stub
		detailsRepository.save(employee);

	}

	@Override
	public void deleteDetails(int employeeId) {
		// TODO Auto-generated method stub
		detailsRepository.deleteById(employeeId);
	}

	@Override
	public List<Details> getAllDetails(int employeeId, Details cityName) {
		// TODO Auto-generated method stub
		return detailsRepository.findAll();
	}

	@Override
	public List<Details> findByCityName(String cityName) {
		// TODO Auto-generated method stub
		return detailsRepository.findByCityName(cityName);
	}

	@Override
	public List<Details> findByEmployeeIdAndCityName(int employeeId, String cityName) {
		// TODO Auto-generated method stub
		return detailsRepository.findByEmployeeIdAndCityName(employeeId, cityName);
	}

	@Override
	public List<Details> findByEmployeeName(String employeeName) {
		// TODO Auto-generated method stub
		return detailsRepository.findByEmployeeName(employeeName);
	}

	@Override
	public List<Details> findByEmployeeNameAndCityName(String employeeName, String cityName) {
		// TODO Auto-generated method stub
		return detailsRepository.findByEmployeeNameAndCityName(employeeName, cityName);
	}

//	@Override
//	public String deleteDetails(Details employee) {
//		Details existingDetails=detailsRepository.findById(employee.getEmployeeId()).orElse(null);
//		if(existingDetails==null)
//			throw new NoSuchDetailsExistsException("No Details Available For the following Id!!!");
//		else {
//			return "Records Deleted Successfully";
//		}
//	}

}
