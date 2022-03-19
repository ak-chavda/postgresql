package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id", nullable = false)
	private long itemId;

	@Column(name = "item_name", nullable = false)
	private String itemName;

	@Column(name = "quantity", nullable = false)
	private int quantity = 1;

	@Column(name = "price", nullable = false)
	private double price;

	public Item(String itemName, int quantity, double price) {
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Items [itemid=" + itemId + ", itemName=" + itemName + ", quantity=" + quantity + ", price=" + price + "]";
	}

}