package com.xavient.dataingest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xavient.dataingest.StreamingPlatform;
import com.xavient.dataingest.service.DataIngestionService;
import com.xavient.dataingest.ui.kafka.KafkaPublisher;

@Service
public class DataIngestionServiceImpl implements DataIngestionService {

	@Autowired
	private KafkaPublisher kafkaPublisher;
	
	@Override
	public void publishToKafka(List<String> lines) {
		publishToKafka(lines, "default");
	}

	@Override
	public void publishToKafka(List<String> lines, StreamingPlatform streamingPlatform) {
		switch (streamingPlatform) {
		case APEX:
			publishToKafka(lines, "topic1");
			break;
		case FLINK:
			publishToKafka(lines, "topic2");
			break;
		case SPARK:
			publishToKafka(lines, "topic3");
			break;
		case STORM:
			publishToKafka(lines, "topic4");
			break;
		default:
			throw new IllegalArgumentException("Invalid streaming platform");

		}
	}

	private void publishToKafka(List<String> lines, String topic) {
		for (String line : lines)
			kafkaPublisher.sendToKafka(line, topic);
	}

}
