package com.demo.hexagonal.infraestructure.repository.h2;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.hexagonal.domain.model.Price;
import com.demo.hexagonal.domain.ports.PriceRepository;
import com.demo.hexagonal.infraestructure.repository.h2.entities.PriceEntity;

@Component
public class JpaPriceRepository implements PriceRepository {

    @Autowired
    SpringJpaRepository priceRepository;

	@Override
	public List<Price> getPriceByBrandProductAndDate(Integer idBrand, Integer idProduct, LocalDateTime eventDate) {
		
		ModelMapper modelMapper = new ModelMapper();
		
		List<PriceEntity> entitiesList = priceRepository.findPriceByBrandProductAndEventDate(idBrand, idProduct, eventDate);
		
		List<Price> priceList = entitiesList
				  .stream()
				  .map(entity -> modelMapper.map(entity, Price.class))
				  .collect(Collectors.toList());
		
		return priceList;
	}
    
}
