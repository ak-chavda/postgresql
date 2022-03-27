//package com.example.model;
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.EntityListeners;
//import javax.persistence.MappedSuperclass;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//import org.springframework.data.annotation.CreatedBy;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedBy;
//import org.springframework.data.annotation.LastModifiedDate;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = { "created_at", "updated_at" })
//public class Audit {
//
//	@JsonProperty("created_by")
//	@Column(name = "created_by", nullable = false, updatable = false)
//	@CreatedBy
//	private String createdBy;
//
//	@JsonProperty("updated_by")
//	@Column(name = "updated_by", nullable = false)
//	@LastModifiedBy
//	private String updatedBy;
//
//	// -----------------------------------------------------------------
//
//	@JsonProperty("created_at")
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "created_at", nullable = false, updatable = false)
//	@CreatedDate
//	private Date createdAt;
//
//	@JsonProperty("updated_at")
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "updated_at", nullable = false)
//	@LastModifiedDate
//	private Date updatedAt;
//
//}
