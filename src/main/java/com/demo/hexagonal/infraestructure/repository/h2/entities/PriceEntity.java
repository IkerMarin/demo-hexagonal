package com.demo.hexagonal.infraestructure.repository.h2.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "PRICES")
public class PriceEntity {
	
	@Id
	@Column (name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column (name = "BRAND_ID")
	private Integer idBrand;
	
	@Column (name = "START_DATE")
	private LocalDateTime startDate;
	
	@Column (name = "END_DATE")
	private LocalDateTime endDate;
	
	@Column (name = "PRICE_LIST")
	private Integer priceType;
	
	@Column (name = "PRODUCT_ID")
	private Integer idProduct;
	
	@Column (name = "PRIORITY")
	private Integer priority;
	
	@Column (name = "PRICE")
	private Float price;
	
	@Column (name = "CURR")
	private String currency;

}
