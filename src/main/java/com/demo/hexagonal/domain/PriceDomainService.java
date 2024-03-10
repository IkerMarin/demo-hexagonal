package com.demo.hexagonal.domain;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.hexagonal.domain.exception.PriceNotFoundException;
import com.demo.hexagonal.domain.model.Price;
import com.demo.hexagonal.domain.ports.PriceRepository;
import com.demo.hexagonal.domain.ports.PriceService;

@Component
public class PriceDomainService implements PriceService {

    @Autowired
    PriceRepository priceRepository;

	@Override
	public Price getPriceByBrandProductAndDate(Integer idBrand, Integer idProduct, LocalDateTime eventDate) {
		
		List<Price> priceList = priceRepository.getPriceByBrandProductAndDate(idBrand, idProduct, eventDate);
		
		Optional<Price> priceFilteredOpt = priceList.stream().sorted(Comparator.comparing(Price::getPriority).reversed()).findFirst();
		
		return priceFilteredOpt.orElseThrow(() -> new PriceNotFoundException());
	}
    
}
