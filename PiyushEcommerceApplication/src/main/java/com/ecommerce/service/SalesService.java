package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.AdminException;
import com.ecommerce.exception.LoginException;
import com.ecommerce.exception.OrderException;
import com.ecommerce.model.Order;



public interface SalesService {

	public List<Order> getAllSalesHandler(String adminKey) throws LoginException, AdminException, OrderException;

	public List<Order> getSalesOfTodayHandler(String adminKey) throws LoginException, AdminException, OrderException;

	public List<Order> getSalesOfLastWeekHandler(String adminKey) throws LoginException, AdminException, OrderException;

	public List<Order> getSalesOfLastMonthHandler(String adminKey)
			throws LoginException, AdminException, OrderException;

	public List<Order> getSalesOfYearHandler(String adminKey) throws LoginException, AdminException, OrderException;

	public List<Order> getAllOrderFromDate(String fromDate, String adminKey)
			throws LoginException, AdminException, OrderException;

	public List<Order> getAllOrderBetweenTwoDates(String fromDate, String toDate, String adminKey)
			throws LoginException, AdminException, OrderException;
	
	

}
