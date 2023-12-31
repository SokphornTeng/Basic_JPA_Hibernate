package JPA_Hibernate.test_JPA_Hibernate.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
public class Controller_entity {

	@GetMapping("/hi")
	public String test() {
		return "Hi Sokphorn";
	}
	
}
