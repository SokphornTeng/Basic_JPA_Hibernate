package JPA_Hibernate.test_JPA_Hibernate.embed;

import java.sql.Date;

import JPA_Hibernate.test_JPA_Hibernate.enums.class_enums;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
public class controller_embedded {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="studentName", length = 30, nullable = false, unique = true)
	private String fullName;
	private int age;
	
	@Transient
	private String listingData;
	
	@Embedded
	private list_info sokphorn_list;
	
	
	
	public String getListingData() {
		return this.fullName + this.age;
	}

	
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
