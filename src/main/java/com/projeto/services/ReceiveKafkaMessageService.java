package com.projeto.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.dto.ShopDTO;
import com.projeto.repositories.ShopReportRepository;

@Service
public class ReceiveKafkaMessageService {

	@Autowired
	private ShopReportRepository reportRepository;

	private static final Logger LOG = LoggerFactory.getLogger(ReceiveKafkaMessageService.class);

	private static final String SHOP_TOPIC_EVENT_NAME = "SHOP_TOPIC_EVENT";

	@Transactional
	@KafkaListener(topics = SHOP_TOPIC_EVENT_NAME, groupId = "group_report")
	public void listenShopTopic(ShopDTO shopDTO) {
		try {
			LOG.info("Compra recebida no tópico: {}.", shopDTO.getIdentifier());
			reportRepository.incrementShopStatus(shopDTO.getStatus());
		} catch (Exception e) {
			LOG.error("Erro no processamento da mensagem", e);
		}
	}

}
