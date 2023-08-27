package redis_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "beginning.springstarter.redis_project.repository")
public class BeginningMain {

	public static void main(String[] args) {
		SpringApplication.run(BeginningMain.class, args);
	}
}
