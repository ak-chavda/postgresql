package com.example.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

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
@Table(name = "item")
public class Item extends RepresentationModel<Item> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "item_name", nullable = false)
	@JsonProperty("item_name")
	private String itemName;

	@Column(name = "quantity", nullable = false)
	@JsonProperty("quantity")
	@Builder.Default
	private int quantity = 1;

	@Column(name = "price", nullable = false)
	@JsonProperty("price")
	private double price;
	
	@OneToMany(mappedBy = "item")
	private List<Review> reviews;

	public Item(String itemName, int quantity, double price) {
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}
}