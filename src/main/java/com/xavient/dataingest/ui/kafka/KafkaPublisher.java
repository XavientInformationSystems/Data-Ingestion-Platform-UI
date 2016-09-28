
package com.xavient.dataingest.ui.kafka;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

@Component
@PropertySource({ "classpath:kafka.properties" })
public class KafkaPublisher {

	@Autowired
	private Environment env;

	private Properties props = new Properties();

	public boolean sendToKafka(String text, String topic) {
		ProducerConfig config = new ProducerConfig(props);
		Producer<String, String> producer = new Producer<String, String>(config);
		KeyedMessage<String, String> data = new KeyedMessage<String, String>(topic, text);
		producer.send(data);
		return true;
	}

	public boolean sendToKafka(String text) {
		ProducerConfig config = new ProducerConfig(props);
		Producer<String, String> producer = new Producer<String, String>(config);
		KeyedMessage<String, String> data = new KeyedMessage<String, String>("visit",
				text);
		producer.send(data);
		return true;
	}

	@PostConstruct
	public void init() {
		props = new Properties();
		props.put("metadata.broker.list", env.getProperty("metadata.broker.list"));
		props.put("serializer.class", env.getProperty("serializer.class"));
		props.put("request.required.acks", env.getProperty("request.required.acks"));
	}

}
