package com.demo.hexagonal.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.demo.hexagonal.application.utils.GeneralUtils;
import com.demo.hexagonal.domain.model.Price;
import com.demo.hexagonal.infraestructure.repository.h2.entities.PriceEntity;

public class TestUtils {
	
	public static final Integer ID_BRAND = 1;
	public static final Integer ID_PRODUCT = 35455;
	public static final Integer PRICE_TYPE = 2;
	public static final String EVENT_DATE = "2020-06-15 10:00:00";
	public static final String BAD_FORMAT_DATE = "2020-6-15 10:00:00";
	public static final Float PRICE = 35.50f;
	public static final String CURRENCY = "EUR";
	public static final Integer PRIORITY = 1;
	public static final Integer ID_PRICE = 1;
	public static final LocalDateTime EVENT_DATE_LD = LocalDateTime.parse(EVENT_DATE, DateTimeFormatter.ofPattern(GeneralUtils.YYYY_MM_DD_HH_MM_SS_PATTERN));
			
	public static Price getPrice() {
		Price price = new Price();

		price.setId(ID_PRICE);
		price.setIdBrand(ID_BRAND);
		price.setIdProduct(ID_PRODUCT);
		price.setPrice(PRICE);
		price.setPriceType(PRICE_TYPE);
		price.setPriority(PRIORITY);
		price.setStartDate(LocalDateTime.now());
		price.setEndDate(LocalDateTime.now());
		price.setCurrency(CURRENCY);
		
		return price;
	}
	
	public static PriceEntity getPriceEntity() {
		PriceEntity price = new PriceEntity();

		price.setId(ID_PRICE);
		price.setIdBrand(ID_BRAND);
		price.setIdProduct(ID_PRODUCT);
		price.setPrice(PRICE);
		price.setPriceType(PRICE_TYPE);
		price.setPriority(PRIORITY);
		price.setStartDate(LocalDateTime.now());
		price.setEndDate(LocalDateTime.now());
		price.setCurrency(CURRENCY);
		
		return price;
	}

}
