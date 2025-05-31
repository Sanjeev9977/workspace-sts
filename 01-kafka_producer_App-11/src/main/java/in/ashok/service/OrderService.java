package in.ashok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import in.ashok.binding.Order;
import in.ashok.constants.AppConstants;

@Service
public class OrderService {
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	
	public String createOder(Order order) {
		kafkaTemplate.send(AppConstants.TOPIC, order);
		
		return "Order created in kafka topic";
		
	}

}
