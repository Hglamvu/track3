package com.multidbs.springbootmdbs.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
@EnableTransactionManagement
@Configuration
@EnableJpaRepositories(
        //kich hoat jpa repositories
        basePackages = "com.multidbs.springbootmdbs.productrepository",
        //chỉ định gói chứa chứ repository của mysql
        entityManagerFactoryRef = "mySqlEntityManagerFactoryBean",
        //set tên cho entityManagerFactoryRef
        transactionManagerRef = "mySqlTransactionManager"
        //set tên cho transactionManagerRef

)
public class MySQLJPAConfiguration {
    @Bean
    LocalContainerEntityManagerFactoryBean mySqlEntityManagerFactoryBean(EntityManagerFactoryBuilder entityManagerFactoryBuilder,@Qualifier("mySqlDatasource") DataSource dataSource){

        return entityManagerFactoryBuilder
                .dataSource(dataSource)
                .packages("com.multidbs.springbootmdbs.productentity")
                //chỉ định gói chứa các entity của mysql
                .build();
    }
    @Bean
    PlatformTransactionManager mySqlTransactionManager(@Qualifier("mySqlEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean emfb){

        return new JpaTransactionManager(emfb.getObject());
    }
}
