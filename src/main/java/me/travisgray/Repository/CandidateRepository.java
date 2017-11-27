package me.travisgray.Repository;

import me.travisgray.Entity.Candidate;
import org.springframework.data.repository.CrudRepository;

public interface CandidateRepository extends CrudRepository<Candidate, Long> {

	Candidate findByUsername(String username);

}
