package com.demo.hexagonal.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.format.DateTimeParseException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.demo.hexagonal.domain.model.Price;
import com.demo.hexagonal.domain.ports.PriceService;
import com.demo.hexagonal.utils.TestUtils;

@ExtendWith({MockitoExtension.class})
public class PricesControllerTest {
	
	@Mock 
	private PriceService priceService;
	
	@InjectMocks
	private PricesController controller;
	
	@Test
	void testGetPriceError() {
		assertThrows(IllegalArgumentException.class, ()-> controller.getPrice(null, null, null));
	}
	
	@Test
	void testGetPriceError2() {
		assertThrows(DateTimeParseException.class, ()-> controller.getPrice(1, 2, "200"));
	}
	
	@Test
	void testGetPrice () {
		Mockito.lenient().when(priceService.getPriceByBrandProductAndDate(Mockito.anyInt(), Mockito.any(), Mockito.any())).thenReturn(TestUtils.getPrice());
		
		ResponseEntity<Price> response = (ResponseEntity<Price>) controller.getPrice(TestUtils.ID_BRAND, TestUtils.ID_PRODUCT, "2023-10-02 10:10:10");
		
		assertNotNull(response);
		assertEquals(1, response.getBody().getId());
	}
	
}
