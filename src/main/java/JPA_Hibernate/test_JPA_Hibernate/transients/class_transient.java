package JPA_Hibernate.test_JPA_Hibernate.transients;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
public class class_transient {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="studentName", length = 30, nullable = false, unique = true)
	private String fullName;
	private int age;
	
	@Transient
	private String listingData;
	
	public String getListingData() {
		return this.fullName + this.age;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="DMY")
	private Date bornDate;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
