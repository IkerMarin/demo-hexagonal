package com.demo.hexagonal.domain.ports;

import java.time.LocalDateTime;

import com.demo.hexagonal.domain.model.Price;

public interface PriceService {

    public Price getPriceByBrandProductAndDate(Integer id, Integer idBrand, LocalDateTime eventDate);
    
}
