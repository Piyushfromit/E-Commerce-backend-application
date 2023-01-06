package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.AdminException;
import com.ecommerce.exception.LoginException;
import com.ecommerce.exception.OrderException;
import com.ecommerce.exception.ProductCategoryException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.exception.UserException;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;



public interface ProductService {

	public Product addProduct(Product product, String sellerKey, Integer categoryId)
			throws LoginException, AdminException, ProductCategoryException, UserException;

	public Product updateProduct(Product product, String sellerKey, Integer productId)
			throws LoginException, AdminException, ProductException, UserException;

	public Product deleteProduct(String sellerKey, Integer productId)
			throws LoginException, AdminException, ProductException, OrderException;

	public Product getProductById(Integer productId) throws ProductException;

	public List<Product> getAllProducts() throws ProductException;

	public List<Product> getProductsUnderPrice(Integer price) throws ProductException;

	public List<Product> getProductsFromPriceToPrice(Integer fromPrice, Integer toPrice) throws ProductException;

	public List<Cart> getAllCartWithProduct(Product product);

	public boolean getProductInOrders(Product product);
}
