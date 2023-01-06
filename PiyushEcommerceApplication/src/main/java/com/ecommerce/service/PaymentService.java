package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.CardException;
import com.ecommerce.exception.LoginException;
import com.ecommerce.exception.OrderException;
import com.ecommerce.exception.PaymentException;
import com.ecommerce.exception.UserException;
import com.ecommerce.model.Payment;



public interface PaymentService {

	public Payment makePayment(Integer orderId, Integer cardId, String customerKey)
			throws LoginException, UserException, OrderException, CardException;

	public String cancelPayment(Integer orderId, String customerKey)
			throws LoginException, UserException, OrderException;

	public Payment getPaymentDetailsByPaymentId(Integer paymentId, String customerKey)
			throws LoginException, UserException, OrderException, PaymentException;

	public Payment getPaymentDetailsByOrderId(Integer orderId, String customerKey)
			throws OrderException, LoginException, UserException, PaymentException;

	public List<Payment> getAllPaymentOfCustomerByCustomerId(String customerKey) throws UserException, LoginException, PaymentException;

}
