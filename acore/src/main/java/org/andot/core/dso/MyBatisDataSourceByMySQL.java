package org.andot.core.dso;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Mybatis  MySql 多数据源创建池
 * @author Andot
 * @date 207-12-6 15:29:22
 *
 * */
@Configuration
@MapperScan(basePackages = "org.andot.core.mapper.mysql", sqlSessionFactoryRef = "sqlSessionFactoryMySqlOne")
public class MyBatisDataSourceByMySQL {

    /**
     * mysql
     * */
    @Bean(name = "dataSourceMySqlOne")
    @ConfigurationProperties(prefix = "spring.dataSource.mysql")
    public DataSource dataSourceMySql() {
        System.err.println("=============DataSourceMySqlOne init==============");
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "transactionManagerMySqlOne")
    public DataSourceTransactionManager dataSourceTransactionManagerMySql(@Qualifier("dataSourceMySqlOne") DataSource ds) {
        System.err.println("=============DataSourceTransactionManagerMySqlOne init==============");
        return new DataSourceTransactionManager(ds);
    }

    @Bean(name = "sqlSessionFactoryMySqlOne")
    public SqlSessionFactory sqlSessionFactoryMySql(@Qualifier("dataSourceMySqlOne") DataSource ds) throws Exception {
        System.err.println("=============SqlSessionFactoryMySqlOne init==============");
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(ds);
        return bean.getObject();
    }
}
