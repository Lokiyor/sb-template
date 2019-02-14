package com.ljy.sbtemplate.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author liusheng
 */
@Configuration
@MapperScan(basePackages = SbtDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "sbtSqlSessionFactory")
public class SbtDataSourceConfig {

    static final String PACKAGE = "com.ljy.sbtemplate.dal.dao.sbt";
    static final String MAPPER_LOCATION = "classpath:com/ljy/sbtemplate/dal/mappers/sbt/**/*.xml";

    @Value("${sbt.datasource.driverClassName}")
    private String driverClass;

    @Value("${sbt.datasource.url}")
    private String url;

    @Value("${sbt.datasource.username}")
    private String username;

    @Value("${sbt.datasource.password}")
    private String password;

    @Value("${sbt.druid.initialSize}")
    private int initialSize;

    @Value("${sbt.druid.minIdle}")
    private int minIdle;

    @Value("${sbt.druid.maxActive}")
    private int maxActive;

    @Value("${sbt.druid.maxWait}")
    private int maxWait;

    @Value("${sbt.druid.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${sbt.druid.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${sbt.druid.validationQuery}")
    private String validationQuery;

    @Value("${sbt.druid.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${sbt.druid.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${sbt.druid.testOnReturn}")
    private boolean testOnReturn;

    @Value("${sbt.druid.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${sbt.druid.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${sbt.druid.filters}")
    private String filters;

    @Value("${sbt.druid.connectionProperties}")
    private String connectionProperties;

    @Bean(name = "sbtDataSource")
    @Primary
    public DataSource sbtDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            dataSource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    // 配置事物管理
    @Bean(name = "sbtTransactionManager")
    @Primary
    public DataSourceTransactionManager sbtTransactionManager() {
        return new DataSourceTransactionManager(sbtDataSource());
    }

    @Bean(name = "sbtSqlSessionFactory")
    @Primary
    public SqlSessionFactory sbtSqlSessionFactory(@Qualifier("sbtDataSource") DataSource sbtDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(sbtDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(SbtDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

}



