package com.demo.hexagonal.infraestructure.repository.h2;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.hexagonal.infraestructure.repository.h2.entities.PriceEntity;

public interface SpringJpaRepository extends JpaRepository<PriceEntity, Integer> {

	@Query(value = "SELECT * FROM PRICES "
			+ "WHERE BRAND_ID = :idBrand "
			+ "AND PRODUCT_ID = :idProduct "
			+ "AND :eventDate BETWEEN START_DATE AND END_DATE ", nativeQuery = true)
	List<PriceEntity> findPriceByBrandProductAndEventDate(Integer idBrand, Integer idProduct, LocalDateTime eventDate);
	
}
