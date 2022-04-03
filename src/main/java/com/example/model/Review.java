package com.example.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "review")
public class Review implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@JsonProperty("id")
	private long id;

	@Column(name = "rating", nullable = false)
	@JsonProperty("rating")
	private double rating;

	@Column(name = "comment")
	@JsonProperty("comment")
	private String comment;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "item_id", referencedColumnName = "id")
	@JsonIgnore // ignore | otherwise recursively items records will fetch
	private Item item;

	public Review(Double rating, String comment) {
		this.rating = rating;
		this.comment = comment;
	}
}