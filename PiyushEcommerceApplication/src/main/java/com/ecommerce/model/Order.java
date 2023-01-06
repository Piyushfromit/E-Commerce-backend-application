package com.ecommerce.model;

import java.time.LocalDate;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import jakarta.persistence.CascadeType;
//import jakarta.persistence.CollectionTable;
//import jakarta.persistence.Column;
//import jakarta.persistence.ElementCollection;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.MapKeyJoinColumn;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Order_Table")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;

	private String orderStatus;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Customer customer;

	@Min(value = 99, message = "Minimum Order amount is 99")
	@Max(value = 99999, message = "Maximun Order amount is 99999")
	private Integer orderAmount;

	private LocalDate orderDate;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "order_table_product", joinColumns = @JoinColumn(name = "order_table_id"))
	@Column(name = "quantity")
	@MapKeyJoinColumn(name = "product_id", referencedColumnName = "productId")
	@JsonIgnore
	private Map<Product, Integer> products;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Address shippingAddress;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Payment payment;

}
