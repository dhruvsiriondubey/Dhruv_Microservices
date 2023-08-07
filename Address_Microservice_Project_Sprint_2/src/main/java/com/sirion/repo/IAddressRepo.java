package com.sirion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sirion.entity.Address;

public interface IAddressRepo extends JpaRepository<Address, Integer>{

}
