package com.multidbs.springbootmdbs;

import com.multidbs.springbootmdbs.orderentity.Order;
import com.multidbs.springbootmdbs.orderrepository.OrderDAO;
import com.multidbs.springbootmdbs.productentity.Product;
import com.multidbs.springbootmdbs.productrepository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SpringBootMdbsApplication implements CommandLineRunner {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private OrderDAO orderDAO;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMdbsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("----------------- Start inserting data ----------------- ");
		Product product = new Product(2, "ring", 200000.00);
		productDAO.save(product);
		Order order = new Order(101, "abc", LocalDate.now());
		orderDAO.save(order);
		System.out.println("----------------- Insertion completed ----------------- ");


	}
}
