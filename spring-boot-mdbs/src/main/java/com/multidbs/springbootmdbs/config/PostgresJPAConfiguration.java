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
            basePackages = "com.multidbs.springbootmdbs.orderrepository",
            //Chỉ định package chứa các repository cho PostgreSQL
            entityManagerFactoryRef = "postgresEntityManagerFactoryBean",
            //Chỉ định bean EntityManagerFactory cho PostgreSQL
            transactionManagerRef = "postgresTransactionManager"
            //Chỉ định bean TransactionManager cho PostgreSQL
    )
    public class PostgresJPAConfiguration {
        @Bean
        LocalContainerEntityManagerFactoryBean postgresEntityManagerFactoryBean(EntityManagerFactoryBuilder entityManagerFactoryBuilder,@Qualifier("postgresSqlDatasource") DataSource dataSource){

            return entityManagerFactoryBuilder
                    .dataSource(dataSource)
                    //Sử dụng DataSource đã cấu hình cho PostgreSQL
                    .packages("com.multidbs.springbootmdbs.orderentity")
                    //Chỉ định package chứa các entity cho PostgreSQL
                    .build();
        }
        @Bean
        //Định nghĩa một bean PlatformTransactionManager cho PostgreSQL
        PlatformTransactionManager postgresTransactionManager(@Qualifier("postgresEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean emfb){

            return new JpaTransactionManager(emfb.getObject());
            //Sử dụng EntityManagerFactory đã cấu hình để tạo TransactionManager
        }
    }
