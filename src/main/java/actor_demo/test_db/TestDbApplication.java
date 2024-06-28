package actor_demo.test_db;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Test DB", description = "Project for trying out a test datasource!"))
public class TestDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestDbApplication.class, args);
	}

}
