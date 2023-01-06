package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.AddressException;
import com.ecommerce.exception.CartException;
import com.ecommerce.exception.LoginException;
import com.ecommerce.exception.OrderException;
import com.ecommerce.exception.UserException;
import com.ecommerce.model.Order;
import com.ecommerce.model.Product;



public interface OrderService {

	public Order viewOrder(Integer orderId, String customerKey) throws LoginException, UserException, OrderException;

	public List<Order> viewAllOrder(String customerKey) throws LoginException, UserException, OrderException;

	public Order deleteOrderByOrderId(Integer orderId, String customerKey)
			throws LoginException, UserException, OrderException;

	public Order updateOrderByOrderId(Order order, Integer orderId, String customerKey)
			throws LoginException, UserException, OrderException;

	public Order placeOrder(String customerKey) throws LoginException, UserException, CartException, AddressException;

	public boolean getProductInOrders(Product product);
}
