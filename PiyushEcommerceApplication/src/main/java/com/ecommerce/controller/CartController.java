package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.AdminException;
import com.ecommerce.exception.CartException;
import com.ecommerce.exception.LoginException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.exception.UserException;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;
import com.ecommerce.service.CartService;



@RestController
@RequestMapping("/cartController")
public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping("/carts")
	public ResponseEntity<List<Product>> getAllProductInCartHandler(@RequestParam String customerkey)
			throws CartException, LoginException, UserException, AdminException, ProductException {

		List<Product> products = cartService.getProductListOfCart(customerkey);

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);

	}

	@GetMapping("/cartValue")
	public ResponseEntity<Integer> getCartValueHandler(@RequestParam String customerkey)
			throws CartException, LoginException, UserException, AdminException, ProductException {

		Integer cartValue = cartService.getCartValue(customerkey);

		return new ResponseEntity<Integer>(cartValue, HttpStatus.OK);

	}

	@PostMapping("/carts")
	public ResponseEntity<Cart> addProductToCartHandler(@RequestParam Integer productId,
			@RequestParam String customerkey)
			throws CartException, LoginException, UserException, AdminException, ProductException {

		Cart savedCart = cartService.addProductToCart(productId, customerkey);

		return new ResponseEntity<Cart>(savedCart, HttpStatus.OK);

	}

	@PutMapping("/carts")
	public ResponseEntity<Cart> removeProductFromCartHandler(@RequestParam Integer productId,
			@RequestParam String customerkey)
			throws CartException, LoginException, UserException, AdminException, ProductException {

		Cart savedCart = cartService.reduceProductQuantityInCart(productId, customerkey);

		return new ResponseEntity<Cart>(savedCart, HttpStatus.OK);

	}

	@PutMapping("/emptyCart")
	public ResponseEntity<Cart> emptyCartHandler(@RequestParam String customerkey)
			throws CartException, LoginException, UserException, AdminException, ProductException {

		Cart savedCart = cartService.emptyCart(customerkey);

		return new ResponseEntity<Cart>(savedCart, HttpStatus.OK);

	}

	@DeleteMapping("/carts")
	public ResponseEntity<Cart> deleteProductFromCartHandler(@RequestParam Integer productId,
			@RequestParam String customerkey)
			throws CartException, LoginException, UserException, AdminException, ProductException {

		Cart savedCart = cartService.deleteProductToCart(productId, customerkey);

		return new ResponseEntity<Cart>(savedCart, HttpStatus.OK);

	}
}
