package in.ashok.config;

import java.applet.AppletContext;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;


import org.springframework.kafka.support.serializer.JsonSerializer;


import in.ashok.constants.AppConstants;

@Configuration
public class KafkaProducerConfig {
	
	@Bean
	public KafkaTemplate<String ,Object> kakKafkaTemplate(){
		return new  KafkaTemplate<>(producerFactory());
	}
	
	
	
	@Bean
	public ProducerFactory<String, Object> producerFactory(){
		
		Map<String,Object> configProps= new HashMap();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstants.Host);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory<String,Object>(configProps);
		
	}

}
