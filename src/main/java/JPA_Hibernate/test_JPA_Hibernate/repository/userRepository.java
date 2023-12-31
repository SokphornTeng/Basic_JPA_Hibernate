package JPA_Hibernate.test_JPA_Hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import JPA_Hibernate.test_JPA_Hibernate.converter.user_entity;

@Repository
public interface userRepository extends JpaRepository<user_entity, Long> {

}
