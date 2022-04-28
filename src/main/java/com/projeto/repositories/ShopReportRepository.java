package com.projeto.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.projeto.domain.ShopReport;

public interface ShopReportRepository extends JpaRepositoryImplementation<ShopReport, Integer> {

	@Modifying
	@Query(value = "update shop_report " + "set amount = amount + 1 "
			+ "where identifier = :shopStatus", nativeQuery = true)
	void incrementShopStatus(String shopStatus);

}
