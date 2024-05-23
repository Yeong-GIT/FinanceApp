package gityeong.financeProject;

import config.DataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@Import(DataSourceConfig.class)
public class FinanceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceProjectApplication.class, args);
	}

}
