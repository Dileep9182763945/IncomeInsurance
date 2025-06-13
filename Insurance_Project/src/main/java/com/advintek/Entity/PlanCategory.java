package com.advintek.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="PLAN_CATEGORY")
@Data
public class PlanCategory {

	@Id
	@GeneratedValue
	@Column(name="CATEGORY_ID")
	private Integer categoryId;
	@Column(name="CATEGORY_TYPE")
	private String categoryType;
	@Column(name="CREATEBY")
	private String createBy;
	@Column(name="UPDATEBY")
	private String updateBy;
	@Column(name="CREATE_DATE")
	@CreationTimestamp
	private LocalDate createDate;
	@Column(name="UPDATE_DATE")
	@UpdateTimestamp
	private LocalDate updateDate;
}
