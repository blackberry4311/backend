package com.platform.papafood.config;

import com.platform.papafood.config.properties.AppProperties;
import com.tpp.persistence.PropertyEntityDAO;
import com.tpp.persistence.PropertyEntityDAOImpl;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DataSourceConfig {

    @Autowired
    private AppProperties appProperties;

    @Autowired
    private ResourceLoader resourceLoader;

    @Primary
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(appProperties.getDatasource().getModelsMaster().getDriverClassName());
        hikariConfig.setJdbcUrl(appProperties.getDatasource().getModelsMaster().getUrl());
        hikariConfig.setMaximumPoolSize(appProperties.getDatasource().getModelsMaster().getMaximumPoolSize());
        hikariConfig.setMinimumIdle(appProperties.getDatasource().getModelsMaster().getMinIdle());
        hikariConfig.setUsername(appProperties.getDatasource().getModelsMaster().getUsername());
        hikariConfig.setPassword(appProperties.getDatasource().getModelsMaster().getPassword());

        return new HikariDataSource(hikariConfig);
    }

    /* Hibernate */
    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        if (appProperties.getDatasource().getModelsMaster().isShowSql()) {
            properties.setProperty("hibernate.show_sql", "true");
            properties.setProperty("hibernate.format_sql", "true");
        }

        // kindly do not change these props below
        properties.setProperty("hibernate.cglib.use_reflection_optimizer", "true");
        properties.setProperty("hibernate.connection.release_mode", "auto");
        properties.setProperty("hibernate.connection.useUnicode", "true");
        properties.setProperty("hibernate.connection.characterEncoding", "UTF-8");
        properties.setProperty("hibernate.connection.charSet", "UTF-8");
        properties.setProperty("hibernate.connection.autoReconnect", "true");
        properties.setProperty("hibernate.connection.autoReconnectForPools", "true");
        properties.setProperty("hibernate.connection.connection.is-connection-validation-required", "true");
        properties.setProperty("hibernate.transaction.flush_before_completion", "true");
        properties.setProperty("hibernate.use.second.level.cache", "true");

        //cause of fucking order between flyway and hibernate ddl so I must disabled it. FIXME
        //        properties.setProperty("hibernate.hbm2ddl.auto", "validate");    // create/update/validate/create-drop

        //        properties.setProperty("hibernate.cache.region.factory_class",
        //                "org.hibernate.cache.ehcache.EhCacheRegionFactory");
        //		properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setHibernateProperties(properties);
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setMappingLocations(ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
                .getResources("classpath:hbm/*.hbm.xml"));

        return sessionFactory;
    }

    @Bean(name = "transactionManager")
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);

        return transactionManager;
    }

    /* Exception Translator */
    @Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    /* JDBCTemplate */
    @Bean(name = "namedParameterJdbcTemplate")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() throws Exception {
        return new NamedParameterJdbcTemplate(this.dataSource());
    }

    @Bean(name = "jdbcTransactionManager")
    public PlatformTransactionManager jdbcTransactionManager() throws Exception {
        return new DataSourceTransactionManager(this.dataSource());
    }

    @Bean(name = "propertyEntityDAO")
    @Autowired
    public PropertyEntityDAO propertyEntityDAO(SessionFactory sessionFactory) {
        return new PropertyEntityDAOImpl(sessionFactory);
    }
}
