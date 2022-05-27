package com.foodmunch.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartNo", updatable = false, nullable = false)
	private int cartNo;

	@Column(name = "totalPrice")
	private float totalPrice;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "custAddressId", referencedColumnName = "custAddressId")
	private CustomerAddress deliveryAddress;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderTableId", referencedColumnName = "orderTableId")
	private OrderTable orderTable;

}
