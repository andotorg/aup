package org.andot.core.dso;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

public interface ComDataSourceByMySQL {

    /**
     * 创建数据库
     * */
    DataSource dataSourceMySql();

    SqlSessionFactory sqlSessionFactoryMySql(DataSource dataSource) throws Exception;

    DataSourceTransactionManager dataSourceTransactionManagerMySql(DataSource dataSource);

    SqlSessionTemplate sqlSessionTemplateMySqlOne(SqlSessionFactory sqlSessionFactory) throws Exception;
}
