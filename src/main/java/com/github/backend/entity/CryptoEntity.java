package com.github.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "crypto")
public class CryptoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "crypto_name")
	private String crypto_name;
	
	@Column(name = "crypto_value")
	private double crypto_value;
	
	@Column(name = "crypto_status")
	private String crypto_status;
	
	public CryptoEntity() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCryptoName() {
		return crypto_name;
	}

	public void setCryptoName(String crypto_name) {
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
	public String toString() {
		return "CryptoEntity [id=" + id + ", crypto_name=" + crypto_name + ", crypto_value=" + crypto_value + ", crypto_status=" + crypto_status
				+ "]";
	}
	
}
