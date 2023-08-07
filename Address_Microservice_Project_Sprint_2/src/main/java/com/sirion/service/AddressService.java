package com.sirion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirion.entity.Address;
import com.sirion.repo.IAddressRepo;

@Service
public class AddressService implements IAddressService {
	@Autowired
	private IAddressRepo repo;

	@Override
	public Address addAddress(Address add) {
		Boolean flag = true;
		List<String> messages = new ArrayList<String>();
		if (add.getAddressId() < 0) {
			messages.add("Address Id can only be a positive");
			flag = false;
		}
		if (add.getBuildingName().matches("[a-z,A-Z]+") == false) {
			messages.add("Building name can only contain the alphabet");
			flag = false;
		}
		if (add.getStreetNo().matches("\\d+") == false) {
			messages.add("Street No. can only contain numbers");
			flag = false;
		}
		if (add.getCity().matches("[a-z,A-Z]+") == false || add.getState().matches("[a-z,A-Z]+") == false
				|| add.getCountry().matches("[a-z,A-Z]+") == false) {
			messages.add("City, State and Country name can only contain the alphabet");
			flag = false;
		}
		if (add.getPincode().matches("\\d+") == false) {
			messages.add("Pincode can only contain numbers");
			flag = false;
		}
		if (flag == false) {
//			throw new IncorrectInputException(messages);
			return null;
		}
		repo.saveAndFlush(add);
		return add;
	}

	@Override
	public Address updateAddress(Address add) {
		Optional<Address> op = repo.findById(add.getAddressId());
		if (op.isPresent()) {
			Boolean flag = true;
			if (add.getAddressId() < 0) {
				System.out.println("Address Id can only be a positive");
				flag = false;
			}
			if (add.getBuildingName().matches("[a-z,A-Z]+") == false) {
				System.out.println("Building name can only contain the alphabet");
				flag = false;
			}
			if (add.getStreetNo().matches("\\d+") == false) {
				System.out.println("Street No. can only contain numbers");
				flag = false;
			}
			if (add.getCity().matches("[a-z,A-Z]+") == false || add.getState().matches("[a-z,A-Z]+") == false
					|| add.getCountry().matches("[a-z,A-Z]+") == false) {
				System.out.println("City, State and Country name can only contain the alphabet");
				flag = false;
			}
			if (add.getPincode().matches("\\d+") == false) {
				System.out.println("Pincode can only contain numbers");
				flag = false;
			}
			if (flag == false)
				return null;
			repo.saveAndFlush(add);
			return add;
		}
		return null;
	}

	@Override
	public void removeAddress(int addressId) {
		repo.deleteById(addressId);
	}

	@Override
	public Address viewAddress(int addressId) {
		Optional<Address> add = repo.findById(addressId);
		if (add.isPresent())
			return add.get();

		return null;
	}

	@Override
	public List<Address> viewAllAddress() {
		return repo.findAll();
	}

}
