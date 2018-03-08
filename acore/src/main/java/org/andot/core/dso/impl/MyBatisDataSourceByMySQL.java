package org.andot.core.dso.impl;


import org.andot.core.dso.ComDataSourceByMySQL;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Mybatis  MySql 多数据源创建池
 * @author Andot
 * @date 2017-12-6 15:29:22
 *
 * */
@Configuration
@MapperScan(basePackages = "org.andot.core.mapper.mysql", sqlSessionFactoryRef = "sqlSessionFactoryMySqlOne")
public class MyBatisDataSourceByMySQL implements ComDataSourceByMySQL {

    /**
     * mysql
     * */
    @Bean(name = "dataSourceMySqlOne")
    @ConfigurationProperties(prefix = "spring.dataSource.mysql")
    @Primary
    @Override
    public DataSource dataSourceMySql() {
        System.err.println("=============DataSourceMySqlOne init==============");
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sqlSessionFactoryMySqlOne")
    @Primary
    @Override
    public SqlSessionFactory sqlSessionFactoryMySql(@Qualifier("dataSourceMySqlOne") DataSource dataSource) throws Exception {
        System.err.println("=============SqlSessionFactoryMySqlOne init==============");
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "transactionManagerMySqlOne")
    @Primary
    @Override
    public DataSourceTransactionManager dataSourceTransactionManagerMySql(@Qualifier("dataSourceMySqlOne") DataSource dataSource) {
        System.err.println("=============DataSourceTransactionManagerMySqlOne init==============");
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name="sqlSessionTemplateMySqlOne")
    @Primary
    @Override
    public SqlSessionTemplate sqlSessionTemplateMySqlOne(@Qualifier("sqlSessionFactoryMySqlOne") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
        return template;
    }
}
