package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.CardException;
import com.ecommerce.exception.LoginException;
import com.ecommerce.exception.UserException;
import com.ecommerce.model.Card;



public interface CardService {

	public Card addCard(Card card, String customerKey) throws LoginException, UserException, CardException;

	public String deleteCard(Integer cardId, String customerKey) throws LoginException, UserException, CardException;

	public Card updateCard(Integer cardId, Card card, String customerKey)
			throws LoginException, UserException, CardException;

	public Card getCardById(Integer cardId, String customerKey) throws LoginException, UserException, CardException;

	public List<Card> getAllCardOfCustomer(String customerKey) throws LoginException, UserException, CardException;

}
