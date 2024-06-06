package com.multidbs.springbootmdbs.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
//lớp cấu hình spring
@Configuration
public class PostGresSqlDatasourceConfiguration {
    @ConfigurationProperties("spring.datasource.pg")
    //spring boot sẽ lấy các thuộc tính cấu hình từ application.properties với prefix: spring.datasource.pg.
    @Bean
    // Định nghĩa một bean DataSourceProperties cho PostgreSQL
    public DataSourceProperties postgresDatasourceProperties(){
        return new DataSourceProperties();
        //trả về DataSourceProperties chứa các thuộc tính cấu hình cho PostgreSQL
    }

    @Primary
    //ưu tiên
    @Bean
    // Định nghĩa một bean DataSource cho PostgreSQL
    DataSource postgresSqlDatasource(){
        return postgresDatasourceProperties().initializeDataSourceBuilder().build();
        // Sử dụng DataSourceProperties để khởi tạo và cấu hình DataSource
    }
}
