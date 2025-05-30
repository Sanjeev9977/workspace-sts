package in.ashok.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
 
import com.fasterxml.jackson.databind.JsonDeserializer;

import in.ashok.binding.Order;
import in.ashok.constants.AppConstants;

@Configuration
public class KafkaConsumerConfig {
	
	 @Bean
     public ConcurrentKafkaListenerContainerFactory<String ,Order> kafkaListnerFactory(){
    	 
    	 ConcurrentKafkaListenerContainerFactory<String,Order> factory=new ConcurrentKafkaListenerContainerFactory<>();
    	 factory.setConsumerFactory(ConsumerFactory());
    	 
    	 return factory;
     }
	
	
	
	@Bean
	public ConsumerFactory<String, Object> ConsumerFactory(){
		
		Map<String,Object> configProps=new HashMap();
		 configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,AppConstants.Host);
		 configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		 configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		
		return new DefaultKafkaConsumerFactory<String,Object>(configProps);
		
	}

}
