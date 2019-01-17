package com.example;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.alibaba.fescar.rm.datasource.DataSourceProxy;
import com.alibaba.fescar.spring.annotation.GlobalTransactionScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@EnableDubboConfiguration
public class ServerPayApplication {



	public static void main(String[] args) {
		SpringApplication.run(ServerPayApplication.class, args);
	}


//	@Autowired
//	ApplicationContext applicationContext;
//
//
//
//	@Bean
//	public JdbcTemplate getJdbcTemplate(){
//		 DruidDataSource dataSource = 	applicationContext.getBean(DruidDataSource.class);
//		return new  JdbcTemplate(new DataSourceProxy(dataSource));
//	}
//
//
//
//	@Bean
//	public GlobalTransactionScanner getGlobalTransactionScanner(){
//		return 	new GlobalTransactionScanner("server-pay" , "my_test_tx_group");
//	}


}

