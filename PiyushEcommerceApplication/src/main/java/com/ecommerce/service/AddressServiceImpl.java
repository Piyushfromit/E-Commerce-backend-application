package com.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.AddressException;
import com.ecommerce.exception.LoginException;
import com.ecommerce.exception.UserException;
import com.ecommerce.model.Address;
import com.ecommerce.model.CurrentUserSession;
import com.ecommerce.model.Customer;
import com.ecommerce.repository.AddressRepo;
import com.ecommerce.repository.CurrentUserSessionRepo;
import com.ecommerce.repository.CustomerRepo;



@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepo addressRepo;

	@Autowired
	private CustomerRepo uRepo;

	@Autowired
	private CurrentUserSessionRepo csdao;

	@Override
	public Address addAddress(Address address, String customerKey)
			throws LoginException, UserException, AddressException {

		CurrentUserSession loggedInUser = csdao.findByUuid(customerKey);

		if (loggedInUser == null) {
			throw new LoginException("Invalid Key Entered");
		}

		if (loggedInUser.getCustomer() == false) {
			throw new UserException("Unauthorized Access! Only Customer can make changes");
		}

		Optional<Customer> existingUser = uRepo.findById(loggedInUser.getUserId());

		if (existingUser.isPresent()) {
			Customer customer = existingUser.get();

			customer.setAddresses(address);

			Address savedAdress = addressRepo.save(address);

			return savedAdress;

		} else {
			throw new UserException("User Not Found");
		}
	}

	@Override
	public String deleteAddress(String customerKey) throws LoginException, UserException, AddressException {

		CurrentUserSession loggedInUser = csdao.findByUuid(customerKey);

		if (loggedInUser == null) {
			throw new LoginException("Invalid Key Entered");
		}

		if (loggedInUser.getCustomer() == false) {
			throw new UserException("Unauthorized Access! Only Customer can make changes");
		}

		Optional<Customer> existingUser = uRepo.findById(loggedInUser.getUserId());

		if (existingUser.isPresent()) {
			Customer customer = existingUser.get();

			Address address = customer.getAddresses();

			if (address != null) {

				addressRepo.delete(address);

				return "Card Deleted Succesfully!";
			} else {
				throw new AddressException("No Address found for this user");
			}
		} else {
			throw new UserException("User Not Found");
		}
	}

	@Override
	public Address updateAddress(Address address, String customerKey)
			throws LoginException, UserException, AddressException {

		CurrentUserSession loggedInUser = csdao.findByUuid(customerKey);

		if (loggedInUser == null) {
			throw new LoginException("Invalid Key Entered");
		}

		if (loggedInUser.getCustomer() == false) {
			throw new UserException("Unauthorized Access! Only Customer can make changes");
		}

		Optional<Customer> existingUser = uRepo.findById(loggedInUser.getUserId());

		if (existingUser.isPresent()) {

			Customer customer = existingUser.get();

			Address existingaddress = customer.getAddresses();

			if (existingaddress != null) {

				customer.setAddresses(address);

				Address savedaddress = addressRepo.save(address);

				return savedaddress;
			} else {
				throw new AddressException("No Address found for this user");
			}

		} else {
			throw new UserException("User Not Found");
		}
	}

	@Override
	public Address getAddressByCustomerKey(String customerKey) throws LoginException, UserException, AddressException {

		CurrentUserSession loggedInUser = csdao.findByUuid(customerKey);

		if (loggedInUser == null) {
			throw new LoginException("Invalid Key Entered");
		}

		if (loggedInUser.getCustomer() == false) {
			throw new UserException("Unauthorized Access! Only Customer can make changes");
		}

		Optional<Customer> existingUser = uRepo.findById(loggedInUser.getUserId());

		if (existingUser.isPresent()) {
			Customer customer = existingUser.get();

			Address existingaddress = customer.getAddresses();

			if (existingaddress != null) {

				return existingaddress;
			} else {
				throw new AddressException("No Address found for this user");
			}

		} else {
			throw new UserException("User Not Found");
		}
	}

//	@Override
//	public List<Address> getAllAddressOfCustomer(String customerKey)
//			throws LoginException, UserException, AddressException {
//
//		CurrentUserSession loggedInUser = csdao.findByUuid(customerKey);
//
//		if (loggedInUser == null) {
//			throw new LoginException("Invalid Key Entered");
//		}
//
//		if (loggedInUser.getCustomer() == false) {
//			throw new UserException("Unauthorized Access! Only Customer can make changes");
//		}
//
//		Optional<Customer> existingUser = uRepo.findById(loggedInUser.getUserId());
//
//		if (existingUser.isPresent()) {
//			Customer customer = existingUser.get();
//
//			List<Address> list = customer.getAddresses();
//
//			if (list.isEmpty() == false)
//				return list;
//			else
//				throw new AddressException("No Address found for this user");
//
//		} else {
//			throw new UserException("User Not Found");
//		}
//	}

}
