package com.demo.hexagonal.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Price {
	
	private Integer id;
	private Integer idBrand;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Integer priceType;
	private Integer idProduct;
	private Integer priority;
	private Float price;
	private String currency;

}
