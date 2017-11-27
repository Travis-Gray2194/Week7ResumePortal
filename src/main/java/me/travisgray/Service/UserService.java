package me.travisgray.Service;

/**
 * Created by ${TravisGray} on 11/26/2017.
 */
import me.travisgray.Entity.UserData;
import me.travisgray.Entity.UserRole;
import me.travisgray.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private EmployerRepository employerRepository;
    private CandidateResumeRepository candidateResumeRepository;
    private CandidateRepository candidateRepository;
    private UserRole userRole;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserData findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public Long countByEmail(String email){
        return userRepository.countByEmail(email);
    }
    public UserData findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public void saveUser(UserData user){
        user.addRole(roleRepository.findByRole("JOBSEEKER"));
        user.setEnabled(true);
        userRepository.save(user);
    }
    public void saveRecruiter(UserData user){
        user.addRole(roleRepository.findByRole("RECRUITER"));
        user.setEnabled(true);
        userRepository.save(user);

    }
}
