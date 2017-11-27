package me.travisgray.Repository;

import me.travisgray.Entity.Candidate;
import me.travisgray.Entity.CandidateResume;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ${TravisGray} on 11/24/2017.
 */
public interface CandidateResumeRepository extends CrudRepository<CandidateResume,Long>{
   List<CandidateResume> findById(int id);

     List<CandidateResume> findAllByFirst(String First);
     List<CandidateResume> findAllByLast(String Last);

    List<CandidateResume> findAllBySchool(String School);

   List<CandidateResume> findAllByCompany(String Company);
    List<CandidateResume> findAllBySkill(String Skill);
}
