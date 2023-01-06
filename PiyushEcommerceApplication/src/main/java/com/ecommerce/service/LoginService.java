package com.ecommerce.service;

import com.ecommerce.exception.LoginException;
import com.ecommerce.model.AdminDto;
import com.ecommerce.model.UserDto;



public interface LoginService {

	public String loginAdmin(AdminDto admin) throws LoginException;

	public String loginUser(UserDto user) throws LoginException;

	public String logoutAdmin(String key) throws LoginException;

	public String logoutUser(String key) throws LoginException;

	public String loginSeller(UserDto user) throws LoginException;

	public String logoutSeller(String key) throws LoginException;

}
