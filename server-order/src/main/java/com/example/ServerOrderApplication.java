package com.example;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.alibaba.fescar.spring.annotation.GlobalTransactionScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDubboConfiguration
public class ServerOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerOrderApplication.class, args);
	}


	@Bean
	public GlobalTransactionScanner getGlobalTransactionScanner(){
		return 	new GlobalTransactionScanner("server-order" , "my_test_tx_group");
	}


}

