package com.sirion.service;

import java.util.List;

import com.sirion.entity.Address;

public interface IAddressService {

	public Address addAddress(Address add);

	public Address updateAddress(Address add);

	public void removeAddress(int addressid);

	public Address viewAddress(int addressid);

	public List<Address> viewAllAddress();
}
