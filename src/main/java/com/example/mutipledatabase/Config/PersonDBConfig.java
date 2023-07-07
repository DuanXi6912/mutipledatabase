package com.example.mutipledatabase.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement

// Cấu hình JPA Repository cho phép truy cập dữ liệu thông qua JPA
@EnableJpaRepositories(
    entityManagerFactoryRef = "personEntityManagerFactory",
    basePackages = {"com.example.mutipledatabase.Repository.Person"},
    transactionManagerRef = "personTransactionManager"
)
public class PersonDBConfig {
    
    @Bean(name = "personDatasource")
    // Cấu hình các thuộc tính kết nối từ tập application.properties
    @ConfigurationProperties(prefix = "spring.datasource.person")
    // method này để tạo DataSource, chứa thông tin kết nối tới cơ sở dữ liệu
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    
    @Bean(name = "personEntityManagerFactory")
    // Phương thức này tạo LocalContainerEntityManagerFactoryBean object
    // sử dụng để cấu hình cho EntityManagerFactory => có thể truy vấn và thao tác với cơ sở dữ liệu thông qua JPA
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder, 
    @Qualifier("personDatasource") DataSource dataSource){
        return builder.dataSource(dataSource).
                packages("com.example.mutipledatabase.Model.Person").
                persistenceUnit("Person").
                build();    
    }

    @Bean(name = "personTransactionManager")
    // Quản lý giao dịch trong ứng dụng => đảm bảo tính toàn vẹn
    public PlatformTransactionManager transactionManager(
        @Qualifier("personEntityManagerFactory") EntityManagerFactory entityManagerFactory
    ){
        return new JpaTransactionManager(entityManagerFactory);
    }
}
