package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.LoginException;
import com.ecommerce.exception.UserException;
import com.ecommerce.model.Customer;
import com.ecommerce.model.RegisterUserDto;



public interface CustomerService {

	public Customer saveUser(RegisterUserDto user) throws UserException;

	public Customer updateUser(RegisterUserDto user, String key) throws UserException, LoginException;

	public Customer deleteUser(String username, String customerKey) throws UserException, LoginException;

	public Customer findByUserLoginId(Integer userLoginId) throws UserException;

	public Customer findByEmail(String email) throws UserException;

	public Customer findByUserName(String userName) throws UserException;

	public Customer findByUserNameOrEmail(String userName, String email) throws UserException;

	public List<Customer> findAllUsers() throws UserException;
}
