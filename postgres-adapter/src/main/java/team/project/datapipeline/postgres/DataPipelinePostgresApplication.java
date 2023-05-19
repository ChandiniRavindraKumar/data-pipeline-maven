package team.project.datapipeline.postgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class DataPipelinePostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataPipelinePostgresApplication.class, args);

		}

}
