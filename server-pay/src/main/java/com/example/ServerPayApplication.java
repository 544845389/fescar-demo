package com.example;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.alibaba.fescar.rm.datasource.DataSourceProxy;
import com.alibaba.fescar.spring.annotation.GlobalTransactionScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@EnableDubboConfiguration
public class ServerPayApplication {



	public static void main(String[] args) {
		SpringApplication.run(ServerPayApplication.class, args);
	}

	@Bean
	public GlobalTransactionScanner getGlobalTransactionScanner(){
		return 	new GlobalTransactionScanner("server-pay" , "my_test_tx_group");
	}

	@Bean
	public DataSourceProxy dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/fescar-pay?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return new DataSourceProxy(dataSource);
	}

	@Bean
	public JdbcTemplate getJdbcTemplate(){
		return new  JdbcTemplate(dataSource());
	}




}

