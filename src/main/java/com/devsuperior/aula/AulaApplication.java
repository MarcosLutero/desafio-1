package com.devsuperior.aula;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.devsuperior.aula.entities.Order;
import com.devsuperior.aula.servicies.OrderService;

@SpringBootApplication
@ComponentScan({"com.devsuperior"})
public class AulaApplication implements CommandLineRunner {
	
	
	private OrderService orderService;
	
	public AulaApplication(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(AulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Integer code = 1034;
        double basic = 800.0;
        double discount = 10.0;
		
        Order order = new Order(code, basic, discount);
        double total = orderService.total(order);
        System.out.println("Pedido código: " + code);
        System.out.printf("Total: %.2f%n", total);
		
		
	}

}
