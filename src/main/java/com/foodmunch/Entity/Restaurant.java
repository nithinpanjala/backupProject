package com.foodmunch.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;





@Entity
@Table(name = "restaurant")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurantId", updatable = false, nullable = false)
	private int restaurantId;
	
	@NotEmpty(message = "Please provide a restaurant Name")
	@Column(name = "restaurantName",unique = true, nullable = false)
	private String restaurantName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurantAddressId", referencedColumnName = "restaurantAddressId")
	private RestaurantAddress restaurantAddress;
	
	@OneToMany(mappedBy = "restaurant")
	@JsonManagedReference(value = "foodMenu")
	private Set<FoodMenu> foodMenu;
	
	@OneToMany(mappedBy = "restaurant")
	@JsonManagedReference(value = "restaurantAdmin")
	private Set<RestaurantAdmin> restaurantAdmin;

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public RestaurantAddress getRestaurantAddress() {
		return restaurantAddress;
	}

	public void setRestaurantAddress(RestaurantAddress restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}

	public Set<FoodMenu> getFoodMenu() {
		return foodMenu;
	}

	public void setFoodMenu(Set<FoodMenu> foodMenu) {
		this.foodMenu = foodMenu;
	}

	public Set<RestaurantAdmin> getRestaurantAdmin() {
		return restaurantAdmin;
	}

	public void setRestaurantAdmin(Set<RestaurantAdmin> restaurantAdmin) {
		this.restaurantAdmin = restaurantAdmin;
	}
	
	
}
