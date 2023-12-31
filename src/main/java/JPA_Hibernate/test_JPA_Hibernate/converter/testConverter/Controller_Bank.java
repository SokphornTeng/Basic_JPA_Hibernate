package JPA_Hibernate.test_JPA_Hibernate.converter.testConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank/api")
public class Controller_Bank {

	private final bankRepository serverBank;
	
	@Autowired
	public Controller_Bank(bankRepository _serverBank) {
		this.serverBank = _serverBank;
	}
	
	@PostMapping
	public ResponseEntity<bank> getBankInfo(@RequestBody requestInfo reqInfo) {
		
		bank bankInfo = new bank();
		bankInfo.setStaff(reqInfo.staff);
		bankInfo.setStaffInfo(reqInfo.employeeInfo);
		
		bank employeeList = this.serverBank.save(bankInfo);
		
		return ResponseEntity.ok(employeeList) ;
		
	}
	
}
