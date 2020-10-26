package com.pef.contract;
import org.json.simple.JSONObject;

public class Contract {

	public String contractId;
	public float capacity;
	public float price;
	public String city;
	
	public Contract(String contractId, float capacity, float price, String city) {
		super();
		this.contractId = contractId;
		this.capacity = capacity;
		this.price = price;
		this.city = city;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public float getCapacity() {
		return capacity;
	}
	public void setCapacity(float capacity) {
		this.capacity = capacity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Contract [contractId=" + contractId + ", capacity=" + capacity + ", price=" + price + ", city=" + city
				+ "]";
	}
	
}
