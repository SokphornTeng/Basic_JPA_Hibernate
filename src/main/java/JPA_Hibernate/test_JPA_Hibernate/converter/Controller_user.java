package JPA_Hibernate.test_JPA_Hibernate.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import JPA_Hibernate.test_JPA_Hibernate.repository.userRepository;

@RestController
@RequestMapping("/api/user")
public class Controller_user {

	private final userRepository userRepo;
	
	@Autowired
	public Controller_user(userRepository _userRepo) {
		this.userRepo = _userRepo;
	}
	
    @PostMapping
	public ResponseEntity<user_entity> create(@RequestBody createUserRequest req){
		
		user_entity userReq = new user_entity();
		userReq.setUsername(req.username);
		userReq.setContactObj(req.contact);
		
		user_entity user = this.userRepo.save(userReq);
		
		return ResponseEntity.ok(user);
	}
	
}
