package eu.arr.minipoco.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import eu.arr.minipoco.service.AccountService;
import eu.arr.minipoco.service.PaymentService;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "eu.arr.minipoco.controller")
public class MvcConfig {
	
	@Bean
	public AccountService accountService(){
		return new AccountService();
	}
	
	@Bean
	public PaymentService paymentService(){
		return new PaymentService();
	}
}
