package config;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    @Bean(name = "customerDataSource")
    public DataSource customerDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/customer_info")
                .username("financeadmin")
                .password("financeadmin")
                .build();
    }

    @Bean(name = "invoiceDataSource")
    public DataSource invoiceDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/invoice_directory")
                .username("financeadmin")
                .password("financeadmin")
                .build();
    }
}

