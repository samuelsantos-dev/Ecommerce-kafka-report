package com.projeto.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.domain.ShopReport;
import com.projeto.repositories.ShopReportRepository;

@Service
public class DBService {
	
	@Autowired
	private ShopReportRepository rep;
	
	
//	“nsert into shop_report(identifier, amount) values('SUCCESS', 0);
//	insert into shop_report(identifier, amount) values('ERROR', 0);”
//
//	Trecho de
//	Apache Kafka e Spring Boot: Comunicação assíncrona entre microsserviços
//	Eduardo Felipe Zambom Santana
//	Este material pode estar protegido por copyright.
	
	public void initDatabase() {
		ShopReport report = new ShopReport(null, "SUCCESS", 0);
		ShopReport report2 = new ShopReport(null, "ERROR", 0);
		
		rep.saveAll(Arrays.asList(report, report2));
	}
	
	
	

}
