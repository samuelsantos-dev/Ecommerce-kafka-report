package com.projeto.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.dto.ShopReportDTO;
import com.projeto.repositories.ShopReportRepository;

@RestController
@RequestMapping(value = "/shop_report")
public class ShopResource {

	@Autowired
	private ShopReportRepository reportRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<ShopReportDTO> getShopReport() {
		return reportRepository.findAll().stream().map(ShopReportDTO::new).collect(Collectors.toList());

	}
}
