package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.FeedbackException;
import com.ecommerce.exception.LoginException;
import com.ecommerce.exception.OrderException;
import com.ecommerce.exception.UserException;
import com.ecommerce.model.Feedback;



public interface FeedbackService {

	public Feedback addFeedBack(Feedback feedback, String key, Integer orderId)
			throws FeedbackException, UserException, OrderException, LoginException;

	public Feedback updateFeedBack(Feedback feedback, String key, Integer feedbackId)
			throws FeedbackException, LoginException, UserException;

	public Feedback viewFeedBack(Integer feedbackId) throws FeedbackException;

	public List<Feedback> viewAllFeedBack() throws FeedbackException;

	public Feedback deleteFeedBack(String key, Integer feedbackId)
			throws FeedbackException, LoginException, UserException;

}
