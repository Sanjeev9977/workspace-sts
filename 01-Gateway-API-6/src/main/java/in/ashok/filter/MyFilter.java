package in.ashok.filter;

import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Set;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;


@Component
public class MyFilter implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// TODO Auto-generated method stub
		
		System.out.println("filter   ()-excuted.......");
		
		ServerHttpRequest request=exchange.getRequest();
		
		org.springframework.http.HttpHeaders headers=request.getHeaders();
		
		
		Set<String> k=headers.keySet();
		
		if(!k.contains("token")) {
			throw new RuntimeException("Invalid requst");
		}
		
		List<String> list=headers.get("token");
		
		if(!list.get(0).equals("sanju@98")) {
			throw new RuntimeException("Invalid token");
		}
		
		
		k.forEach(key ->{
			List<String> values=headers.get(key);
			System.out.println(key +"  : : "+values);
		});
		
		System.out.println("______________________________________________");
		
		
		
		
		
		
		return chain.filter(exchange);
	}
	
	

}
