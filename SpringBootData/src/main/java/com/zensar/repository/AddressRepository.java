package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
