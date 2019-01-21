package com;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.alibaba.fescar.rm.RMClientAT;
import com.alibaba.fescar.rm.datasource.DataSourceProxy;
import com.alibaba.fescar.spring.annotation.GlobalTransactionScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

@Configuration
@SpringBootApplication
@EnableDubboConfiguration
public class ServerUserApplication {

	public static void main(String[] args) {
		RMClientAT.init("server-user" , "my_test_tx_group");
		SpringApplication.run(ServerUserApplication.class, args);
	}


	@Bean
	public GlobalTransactionScanner getGlobalTransactionScanner(){
		return 	new GlobalTransactionScanner("server-user" , "my_test_tx_group");
	}


	@Bean
	public DataSourceProxy dataSource() throws SQLException {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/fescar-user?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return new DataSourceProxy(dataSource);
	}


	@Bean
	public JdbcTemplate getJdbcTemplate() throws SQLException {
		return new  JdbcTemplate(dataSource());
	}



}

