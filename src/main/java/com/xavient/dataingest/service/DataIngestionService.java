package com.xavient.dataingest.service;

import java.util.List;

import com.xavient.dataingest.StreamingPlatform;

public interface DataIngestionService {

	void publishToKafka(List<String> readLines);

	void publishToKafka(List<String> readLines, StreamingPlatform streamingPlatform);
}
