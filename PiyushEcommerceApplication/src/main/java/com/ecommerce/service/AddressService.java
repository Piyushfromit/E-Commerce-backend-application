package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.AddressException;
import com.ecommerce.exception.LoginException;
import com.ecommerce.exception.UserException;
import com.ecommerce.model.Address;



public interface AddressService {

	public Address addAddress(Address address, String customerKey)
			throws LoginException, UserException, AddressException;

	public String deleteAddress(String customerKey) throws LoginException, UserException, AddressException;

	public Address updateAddress(Address address, String customerKey)
			throws LoginException, UserException, AddressException;

	public Address getAddressByCustomerKey(String customerKey) throws LoginException, UserException, AddressException;

//	public List<Address> getAllAddressOfCustomer(String customerKey)
//			throws LoginException, UserException, AddressException;

}
