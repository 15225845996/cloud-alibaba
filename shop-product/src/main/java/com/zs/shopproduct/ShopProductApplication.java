package com.zs.shopproduct;

import com.alibaba.druid.pool.DruidDataSource;
import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("com/zs/shopproduct/mapper")
@EnableDiscoveryClient
public class ShopProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopProductApplication.class, args);
	}

	/*@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public HikariDataSource hikariDataSource() {
		return new HikariDataSource();
	}

	@Primary
	@Bean
	public DataSourceProxy dataSource(HikariDataSource hikariDataSource) {
		return new DataSourceProxy(hikariDataSource);
	}*/

}
