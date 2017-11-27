package me.travisgray.Repository;

import me.travisgray.Entity.Candidate;
import me.travisgray.Entity.UserRole;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ${TravisGray} on 11/26/2017.
 */
public interface RoleRepository  extends CrudRepository<UserRole, Long> {
    UserRole findByRole(String role);

}
