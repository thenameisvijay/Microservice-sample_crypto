package com.github.backend.model;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Category Model")
public class CryptoData {
	
	@ApiModelProperty("crypto ID")
	private int Id;
	
	@ApiModelProperty("crypto name")
	private String crypto_name;
	
	@ApiModelProperty("crypto value")
	private double crypto_value;
	
	@ApiModelProperty("crypto status whether its up/down")
	private String crypto_status;

	public CryptoData() {
		
	}
	
	public CryptoData(int id, String crypto_name, double crypto_value, String crypto_status) {
		super();
		Id = id;
		this.crypto_name = crypto_name;
		this.crypto_value = crypto_value;
		this.crypto_status = crypto_status;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return crypto_name;
	}

	public void setName(String crypto_name) {
		this.crypto_name = crypto_name;
	}

	public double getValue() {
		return crypto_value;
	}

	public void setValue(double crypto_value) {
		this.crypto_value = crypto_value;
	}

	public String getStatus() {
		return crypto_status;
	}

	public void setStatus(String crypto_status) {
		this.crypto_status = crypto_status;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(Id, crypto_name, crypto_status, crypto_value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CryptoData other = (CryptoData) obj;
		return Id == other.Id && Objects.equals(crypto_name, other.crypto_name) 
				&& Objects.equals(crypto_status, other.crypto_status)
				&& Double.doubleToLongBits(crypto_value) == Double.doubleToLongBits(other.crypto_value);
	}
	
	
	
}
