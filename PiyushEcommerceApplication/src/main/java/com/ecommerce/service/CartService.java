package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.AdminException;
import com.ecommerce.exception.LoginException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.exception.UserException;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;


public interface CartService {

	public Cart addProductToCart(Integer productId, String customerKey)
			throws LoginException, UserException, AdminException, ProductException;

	public Cart increaseProductQuantityInCart(Integer productId, String customerKey)
			throws LoginException, UserException, AdminException, ProductException;

	public Cart reduceProductQuantityInCart(Integer productId, String customerKey)
			throws LoginException, UserException, AdminException, ProductException;

	public Cart deleteProductToCart(Integer productId, String customerKey)
			throws LoginException, UserException, AdminException, ProductException;

	public List<Product> getProductListOfCart(String customerKey)
			throws LoginException, UserException, AdminException, ProductException;

	public Integer getCartValue(String customerKey)
			throws LoginException, UserException, AdminException, ProductException;

	public Cart emptyCart(String customerkey) throws LoginException, UserException, AdminException, ProductException;

	public List<Cart> getAllCartWithProduct(Product product);
}
