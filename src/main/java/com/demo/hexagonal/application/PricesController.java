package com.demo.hexagonal.application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.hexagonal.application.utils.ApiConstants;
import com.demo.hexagonal.application.utils.GeneralUtils;
import com.demo.hexagonal.domain.model.Price;
import com.demo.hexagonal.domain.ports.PriceService;

import io.micrometer.common.util.StringUtils;

@RestController
@RequestMapping(ApiConstants.PRICES_CONTROLLER_PATH)
public class PricesController {
	
	@Autowired
	private PriceService priceService;

    @GetMapping(ApiConstants.GET_PRICE_ENDPOINT)
    public ResponseEntity<Price> getPrice(Integer idBrand, Integer idProduct, String eventDate){
    	
    	if(null == idBrand || null == idProduct || StringUtils.isBlank(eventDate)){
    		throw new IllegalArgumentException();
    	}
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(GeneralUtils.YYYY_MM_DD_HH_MM_SS_PATTERN);
    	
    	LocalDateTime specificDate = null;
    	
    	try{
    		specificDate = LocalDateTime.parse(eventDate, formatter);
    	}catch(DateTimeParseException e) {
    		throw e;
    	}
    	
    	Price price = priceService.getPriceByBrandProductAndDate(idBrand, idProduct, specificDate);
    	
        return ResponseEntity.ok(price);
    }

}
