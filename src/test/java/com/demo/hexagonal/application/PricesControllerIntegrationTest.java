package com.demo.hexagonal.application;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.demo.hexagonal.application.utils.ApiConstants;
import com.demo.hexagonal.application.utils.GeneralUtils;

@SpringBootTest
@AutoConfigureMockMvc
public class PricesControllerIntegrationTest {
	
	@Autowired
    private MockMvc mvc;
	
	@Test
	public void getCorrectPrice1() throws Exception 
	{
		mvc.perform(MockMvcRequestBuilders
				.get(ApiConstants.PRICES_CONTROLLER_PATH+ApiConstants.GET_PRICE_ENDPOINT)
				.param("idBrand", "1")
				.param("idProduct", "35455")
				.param("eventDate", "2020-06-14 10:00:00")
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.priceType").value(1))
		.andExpect(MockMvcResultMatchers.jsonPath("$.idBrand").value(1))
		.andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.5))
		.andExpect(MockMvcResultMatchers.jsonPath("$.priority").value(0));
	}
	
	@Test
	public void getCorrectPrice2() throws Exception 
	{
		mvc.perform(MockMvcRequestBuilders
				.get(ApiConstants.PRICES_CONTROLLER_PATH+ApiConstants.GET_PRICE_ENDPOINT)
				.param("idBrand", "1")
				.param("idProduct", "35455")
				.param("eventDate", "2020-06-14 16:00:00")
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.priceType").value(2))
		.andExpect(MockMvcResultMatchers.jsonPath("$.idBrand").value(1))
		.andExpect(MockMvcResultMatchers.jsonPath("$.price").value(25.45))
		.andExpect(MockMvcResultMatchers.jsonPath("$.priority").value(1));
	}
	
	@Test
	public void getCorrectPrice3() throws Exception 
	{
		mvc.perform(MockMvcRequestBuilders
				.get(ApiConstants.PRICES_CONTROLLER_PATH+ApiConstants.GET_PRICE_ENDPOINT)
				.param("idBrand", "1")
				.param("idProduct", "35455")
				.param("eventDate", "2020-06-14 21:00:00")
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.priceType").value(1))
		.andExpect(MockMvcResultMatchers.jsonPath("$.idBrand").value(1))
		.andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.5))
		.andExpect(MockMvcResultMatchers.jsonPath("$.priority").value(0));
	}
	
	@Test
	public void getCorrectPrice4() throws Exception 
	{
		mvc.perform(MockMvcRequestBuilders
				.get(ApiConstants.PRICES_CONTROLLER_PATH+ApiConstants.GET_PRICE_ENDPOINT)
				.param("idBrand", "1")
				.param("idProduct", "35455")
				.param("eventDate", "2020-06-15 10:00:00")
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.priceType").value(3))
		.andExpect(MockMvcResultMatchers.jsonPath("$.idBrand").value(1))
		.andExpect(MockMvcResultMatchers.jsonPath("$.price").value(30.5))
		.andExpect(MockMvcResultMatchers.jsonPath("$.priority").value(1));
	}
	
	@Test
	public void getCorrectPrice5() throws Exception 
	{
		mvc.perform(MockMvcRequestBuilders
				.get(ApiConstants.PRICES_CONTROLLER_PATH+ApiConstants.GET_PRICE_ENDPOINT)
				.param("idBrand", "1")
				.param("idProduct", "35455")
				.param("eventDate", "2020-06-16 21:00:00")
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.priceType").value(4))
		.andExpect(MockMvcResultMatchers.jsonPath("$.idBrand").value(1))
		.andExpect(MockMvcResultMatchers.jsonPath("$.price").value(38.95))
		.andExpect(MockMvcResultMatchers.jsonPath("$.priority").value(1));
	}
	
	@Test
	public void getPriceNotFoundException() throws Exception 
	{
		mvc.perform(MockMvcRequestBuilders
				.get(ApiConstants.PRICES_CONTROLLER_PATH+ApiConstants.GET_PRICE_ENDPOINT)
				.param("idBrand", "8")
				.param("idProduct", "35455")
				.param("eventDate", "2020-06-14 10:00:00")
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().is(404))
		.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(HttpStatus.NOT_FOUND.getReasonPhrase()));
	}
	
	@Test
	public void getAllParametersRequiredException() throws Exception 
	{
		mvc.perform(MockMvcRequestBuilders
				.get(ApiConstants.PRICES_CONTROLLER_PATH+ApiConstants.GET_PRICE_ENDPOINT)
				.param("idProduct", "35455")
				.param("eventDate", "2020-06-14 10:00:00")
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().is(400))
		.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(HttpStatus.BAD_REQUEST.getReasonPhrase()))
		.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Todos los parámetros son obligatorios"));
	}
	
	@Test
	public void getErrorParsingDateException() throws Exception 
	{
		mvc.perform(MockMvcRequestBuilders
				.get(ApiConstants.PRICES_CONTROLLER_PATH+ApiConstants.GET_PRICE_ENDPOINT)
				.param("idBrand", "8")
				.param("idProduct", "35455")
				.param("eventDate", "14-05-2020 10:00:00")
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().is(400))
		.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(HttpStatus.BAD_REQUEST.getReasonPhrase()))
		.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Formato de fecha erróneo: El formato ha de ser: "+GeneralUtils.YYYY_MM_DD_HH_MM_SS_PATTERN));
	}

}
