package in.ashok.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashok.binding.Order;
import in.ashok.service.OrderService;

@RestController
public class OrderRestController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order")
	public String placeOrder(@RequestBody Order order) {
		
		return orderService.createOder(order);
	}

}
