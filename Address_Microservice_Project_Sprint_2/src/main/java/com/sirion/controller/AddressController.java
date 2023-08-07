package com.sirion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sirion.entity.Address;
import com.sirion.service.AddressService;

import jakarta.validation.Valid;
import jakarta.ws.rs.Path;

@RestController
@RequestMapping("address")
public class AddressController {
	@Autowired
	private AddressService as;

	@GetMapping("/{addressId}")
	public Address getAddress(@PathVariable int addressId) {
		return as.viewAddress(addressId);
	}

	@GetMapping("/all")
	public List<Address> getAddress() {
		return as.viewAllAddress();
	}

	@PostMapping
	public Address addAddress(@RequestBody Address add) {
		return as.addAddress(add);
	}

	@PutMapping
	public Address updateAddress(@RequestBody Address add) {
		return as.updateAddress(add);
	}

	@DeleteMapping("/{addressId}")
	public void deleteAddress(@PathVariable int addressId) {
		as.removeAddress(addressId);
	}
}
