package com.zs.shopproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EntityScan("com.zs.common.entry.product")
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
