package me.travisgray.Repository;

import me.travisgray.Entity.UserData;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ${TravisGray} on 11/26/2017.
 */
public interface UserRepository extends CrudRepository<UserData,Long> {
    UserData findByUsername(String username);
    UserData findByEmail(String email);
    Long countByEmail(String email);
    Long countByUsername(String username);
}