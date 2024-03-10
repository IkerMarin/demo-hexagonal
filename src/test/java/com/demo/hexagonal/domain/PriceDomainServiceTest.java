package com.demo.hexagonal.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.hexagonal.domain.exception.PriceNotFoundException;
import com.demo.hexagonal.domain.model.Price;
import com.demo.hexagonal.domain.ports.PriceRepository;
import com.demo.hexagonal.utils.TestUtils;

@ExtendWith({MockitoExtension.class})
public class PriceDomainServiceTest {
	
	@Mock 
	private PriceRepository repository;
	
	@InjectMocks
	private PriceDomainService service;
	
	@Test
	void testGetPrice () {
		Mockito.lenient().when(repository.getPriceByBrandProductAndDate(Mockito.anyInt(), Mockito.any(), Mockito.any())).thenReturn(Arrays.asList(TestUtils.getPrice()));
		
		Price response = service.getPriceByBrandProductAndDate(TestUtils.ID_BRAND, TestUtils.ID_PRODUCT, TestUtils.EVENT_DATE_LD);
		
		assertNotNull(response);
		assertEquals(TestUtils.PRICE, response.getPrice());
	}
	
	@Test
	void testGetPriceNotFound () {
		Mockito.lenient().when(repository.getPriceByBrandProductAndDate(Mockito.anyInt(), Mockito.any(), Mockito.any())).thenReturn(Collections.emptyList());
		
		assertThrows(PriceNotFoundException.class, ()-> service.getPriceByBrandProductAndDate(TestUtils.ID_BRAND, TestUtils.ID_PRODUCT, TestUtils.EVENT_DATE_LD));
	}
	
}
