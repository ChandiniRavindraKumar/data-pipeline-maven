package team.project.datapeline.postgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import team.project.datapipeline.postgres.model.Actor;
import team.project.datapipeline.postgres.repository.ActorRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DataPipelinePostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(team.project.datapeline.postgres.DataPipelinePostgresApplication.class, args);

		}

}
