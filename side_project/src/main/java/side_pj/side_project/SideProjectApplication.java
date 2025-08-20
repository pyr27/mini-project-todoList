package side_pj.side_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("side_pj.side_project.domain")
@EnableJpaRepositories("side_pj.side_project.repository")
public class SideProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SideProjectApplication.class, args);
	}

}
