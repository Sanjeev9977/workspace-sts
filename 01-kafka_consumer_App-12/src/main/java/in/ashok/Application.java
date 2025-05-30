package in.ashok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import in.ashok.constants.AppConstants;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@KafkaListener(topics = AppConstants.TOPIC,groupId = "group_ashokit_orders")
	public void getmsg(String order) {
		
		System.out.println("**** Msg Resived From Kaffka Topic  **");
		System.out.println(order);
	}

}
