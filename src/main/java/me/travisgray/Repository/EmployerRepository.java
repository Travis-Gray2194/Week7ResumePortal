package me.travisgray.Repository;

import me.travisgray.Entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmployerRepository extends CrudRepository<Employer, Long> {
	Employer findByUsername(@Param("username") String username);
}
