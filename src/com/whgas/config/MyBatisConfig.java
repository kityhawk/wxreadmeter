package com.whgas.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(value = {"com.whgas.dao"})
public class MyBatisConfig {
	
	@Autowired
	private MultipleDataSource mDataSource;
	
	@Bean("sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory() throws Exception 
	{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(mDataSource);
		sqlSessionFactoryBean.setTypeAliasesPackage("com.whgas.model");	       //用分号分割多个路径
		//sqlSessionFactoryBean.setMapperLocations(new Resource[]{ new ClassPathResource("cstm/dao/*.xml") } );
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager()
	{
		DataSourceTransactionManager DataSourceTransactionManager = new DataSourceTransactionManager();
		DataSourceTransactionManager.setDataSource(mDataSource);
		return DataSourceTransactionManager;
		
	}
}
