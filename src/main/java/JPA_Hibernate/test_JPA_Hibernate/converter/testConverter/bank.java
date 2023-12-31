package JPA_Hibernate.test_JPA_Hibernate.converter.testConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Woori_Bank")
public class bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 100)
	private String staff;
	
	@Column(name = "info_staff")
	@Convert(converter = objConverterInfo.class)
	private staff_Info staffInfo;
	
	
	public staff_Info getStaffInfo() {
		return staffInfo;
	}
	public void setStaffInfo(staff_Info staffInfo) {
		this.staffInfo = staffInfo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStaff() {
		return staff;
	}
	public void setStaff(String staff) {
		this.staff = staff;
	}
	
	
	
}
