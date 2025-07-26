package lk.ijse.cmjd_110.courseRegisterPro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CourseRegisterProApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseRegisterProApplication.class, args);
	}

}
