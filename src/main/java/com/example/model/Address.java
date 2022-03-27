package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "address")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "address", nullable = false)
	@JsonProperty("address")
	private String address;

	@Column(name = "pincode", nullable = false)
	@JsonProperty("pincode")
	private String pinCode;

	@OneToOne(mappedBy = "address")
	@JsonIgnore // require | to ignore from fetch user recursively
	private User user;
	
	public Address(String address, String pinCode) {
		this.address = address;
		this.pinCode = pinCode;
	}

}