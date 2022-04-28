package com.projeto.dto;

import com.projeto.domain.ShopReport;

public class ShopReportDTO {

	private String identifier;
	private Integer ammount;

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public Integer getAmmount() {
		return ammount;
	}

	public void setAmmount(Integer ammount) {
		this.ammount = ammount;
	}

	public ShopReportDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShopReportDTO(ShopReport report) {
		super();
		this.identifier = report.getIdentifier();
		this.ammount = report.getAmount();
	}

}
