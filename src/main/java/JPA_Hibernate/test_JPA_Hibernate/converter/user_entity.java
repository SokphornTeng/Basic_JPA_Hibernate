package JPA_Hibernate.test_JPA_Hibernate.converter;

import java.util.Objects;

import org.hibernate.Hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class user_entity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=30, nullable=false)
	private String username;
	
	@Column(length=100)
	@Convert(converter = contactObjConvertor.class)
	private contact_object contactObj;
	
	
	

	public contact_object getContactObj() {
		return contactObj;
	}

	public void setContactObj(contact_object contactObj) {
		this.contactObj = contactObj;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	@Override
	public boolean equals(Object o) {
		if(this==o) return true;
		if(o==null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		user_entity that = (user_entity) o ;
		return id != null && Objects.equals(id, that.id);
	}
	
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
	
}
