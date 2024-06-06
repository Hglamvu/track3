    package com.multidbs.springbootmdbs.config;

    import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
    import org.springframework.boot.context.properties.ConfigurationProperties;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import javax.sql.DataSource;
    //lớp cấu hình spring
    @Configuration
    public class MySqlDatasourceConfiguration {
        @ConfigurationProperties("spring.datasource.mysql")
        //Lấy các thuộc tính cấu hình từ application.properties với prefix là spring.datasource.mysql
        @Bean
        //định nghĩa 1 bean datasource cho mysql
        public DataSourceProperties mySqlDatasourceProperties(){
            return new DataSourceProperties();
        }
        @Bean
        // Sử dụng DataSourceProperties để khởi tạo và cấu hình DataSource
        DataSource mySqlDatasource(){
            return mySqlDatasourceProperties().initializeDataSourceBuilder().build();
        }
    }
