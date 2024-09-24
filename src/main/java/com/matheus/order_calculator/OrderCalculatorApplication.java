package com.matheus.order_calculator;

import com.matheus.order_calculator.model.Order;
import com.matheus.order_calculator.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class OrderCalculatorApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;


	public static void main(String[] args) {
		SpringApplication.run(OrderCalculatorApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		Order order = new Order();

		System.out.print("Código do pedido: ");
		order.setCode(scanner.nextInt());

		System.out.print("Valor básico: ");
		order.setBasic(scanner.nextDouble());

		System.out.print("Percentual de disconto: ");
		order.setDiscount(scanner.nextDouble());

		String total = String.format("%.2f", this.orderService.total(order));

		System.out.println("=================================");
		System.out.println("Pedido código " + order.getCode());
		System.out.println("Valor total: R$ " + total);
	}
}
