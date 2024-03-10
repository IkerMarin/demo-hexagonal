package com.demo.hexagonal.infraestructure;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.hexagonal.infraestructure.repository.h2.JpaPriceRepository;
import com.demo.hexagonal.infraestructure.repository.h2.SpringJpaRepository;
import com.demo.hexagonal.infraestructure.repository.h2.entities.PriceEntity;
import com.demo.hexagonal.utils.TestUtils;

@ExtendWith({MockitoExtension.class})
public class JpaPriceRepositoryTest {
	
	@Mock 
	private SpringJpaRepository repository;
	
	@InjectMocks
	private JpaPriceRepository service;
	
	@Test
	void testGetPriceNotFound () {
		Mockito.lenient().when(repository.findPriceByBrandProductAndEventDate(Mockito.anyInt(), Mockito.any(), Mockito.any())).thenReturn(Arrays.asList(TestUtils.getPriceEntity()));
		
		List<PriceEntity> result = repository.findPriceByBrandProductAndEventDate(1, 2, LocalDateTime.now());
		
		assertNotNull(result);
	}
	
}
