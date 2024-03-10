package com.demo.hexagonal.domain.ports;

import java.time.LocalDateTime;
import java.util.List;

import com.demo.hexagonal.domain.model.Price;

public interface PriceRepository {
	
	public List<Price> getPriceByBrandProductAndDate(Integer idBrand, Integer idProduct, LocalDateTime eventDate);

}
