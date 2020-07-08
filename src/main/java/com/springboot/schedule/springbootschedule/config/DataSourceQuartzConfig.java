package com.springboot.schedule.springbootschedule.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.springboot.schedule.springbootschedule.mapper", sqlSessionFactoryRef  = "quartzSqlSessionFactory")
public class DataSourceQuartzConfig {
	
    private final String sqlmap = "classpath*:mapper/*.xml";
	
    @Bean(name = "quartzDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.quartz")
    public DataSource getDateSource() {
        return DataSourceBuilder.create().build();
    }
    
    @Bean(name = "quartzSqlSessionFactory")
    public SqlSessionFactory quartzSqlSessionFactory(@Qualifier("quartzDataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(sqlmap));
//        bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(mybatisConfig));
        return bean.getObject();
    }
    
    @Bean(name = "quartzTransactionManager")
    public DataSourceTransactionManager quartzTransactionManager(@Qualifier("quartzDataSource") DataSource dataSource) {
    	
    	DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
    	System.out.println("primary: " + dataSourceTransactionManager);
        return dataSourceTransactionManager;
    }
}
