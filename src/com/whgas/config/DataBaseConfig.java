package com.whgas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@PropertySource("classpath:com/whgas/config/jdbc.properties")
public class DataBaseConfig {
	@Autowired
    private Environment env;
	
	//@Profile("development")
	@Bean(name="localDataSource")
	public DruidDataSource localDataSource()
	{
		System.out.println("Creating local database");
		DruidDataSource  dataSource = new DruidDataSource();
		dataSource.setDriverClassName(env.getProperty("local.driverClassName"));
		dataSource.setUrl(env.getProperty("local.url"));
		dataSource.setUsername(env.getProperty("local.username"));
		dataSource.setPassword(env.getProperty("local.password"));
		dataSource.setValidationQuery(env.getProperty("local.validationQuery"));
		dataSource.setInitialSize(10);
		dataSource.setMaxActive(100);
		return dataSource;
	}
	
	//@Profile("development")
	@Bean(name="remoteDataSource")
	public DruidDataSource remoteDataSource()
	{
		System.out.println("Creating remote database");
		DruidDataSource  dataSource = new DruidDataSource();
		dataSource.setDriverClassName(env.getProperty("remote.driverClassName"));
		dataSource.setUrl(env.getProperty("remote.url"));
		dataSource.setUsername(env.getProperty("remote.username"));
		dataSource.setPassword(env.getProperty("remote.password"));
		dataSource.setValidationQuery(env.getProperty("remote.validationQuery"));
		dataSource.setInitialSize(10);
		dataSource.setMaxActive(100);
		return dataSource;
	}
}
