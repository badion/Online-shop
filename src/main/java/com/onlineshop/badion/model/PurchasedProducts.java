package com.onlineshop.badion.model;

public class PurchasedProducts {

	private Integer id;
	private Integer idCustomer;
	private String shipping;
	private String country;
	private String city;
	private String address;
	private Integer idOrder;
	private Double totalSum;
	
	public PurchasedProducts() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getShipping() {
		return shipping;
	}
	public void setShipping(String shippingType) {
		this.shipping = shippingType;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(Integer checkoutProductId) {
		this.idOrder = checkoutProductId;
	}
	public Double getTotalSum() {
		return totalSum;
	}
	public void setTotalSum(Double totalSum) {
		this.totalSum = totalSum;
	}
	@Override
	public String toString() {
		return "PurchasedProducts [id=" + id + ", idCustomer=" + idCustomer
				+ ", shippingType=" + shipping + ", country=" + country
				+ ", city=" + city + ", address=" + address
				+ ", checkoutProductId=" + idOrder + ", totalSum="
				+ totalSum + "]";
	}
	public PurchasedProducts(Integer idCustomer,
			String shippingType, String country, String city, String address,
			Integer checkoutProductId, Double totalSum) {
		super();
		
		this.idCustomer = idCustomer;
		this.shipping = shippingType;
		this.country = country;
		this.city = city;
		this.address = address;
		this.idOrder = checkoutProductId;
		this.totalSum = totalSum;
	}
	
	
	
}
