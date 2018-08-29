package com.whgas.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
//import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@ComponentScan(basePackages={"com.whgas"}
,excludeFilters={@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)}
)
public class RootConfig 
{
	@Autowired //@Qualifier("remoteDataSource")
	private DruidDataSource remoteDataSource;
	
	@Autowired //@Qualifier("localDataSource")
	private DruidDataSource localDataSource;
	
	@Bean
	public MultipleDataSource multipleDataSource()
	{
		Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
		targetDataSources.put("remoteDataSource",remoteDataSource);
		targetDataSources.put("localDataSource", localDataSource);
		
		MultipleDataSource mDataSource = new MultipleDataSource();
		mDataSource.setDefaultTargetDataSource(localDataSource);
		mDataSource.setTargetDataSources(targetDataSources);
		return mDataSource;
	}
}
