package me.travisgray.DataLoader;

/**
 * Created by ${TravisGray} on 11/24/2017.
 */

import me.travisgray.Entity.Employer;
import me.travisgray.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    CandidateRepository candidateRepository;


    @Autowired
    CandidateResumeRepository  candidateResumeRepository;

    @Autowired
    EmployerRepository employerRepository;



    @Override
    public void run(String... strings) throws Exception{
        System.out.println("Loading data. . .");

//        Candidate candidate = new Candidate("Travis","Penn State University","axe12392@gmail.com","tgray.linked.in","travis","pizza","Open");
//        candidateRepository.save(candidate);

        Employer employer = new Employer("Montgromery","montcollege@gmail.com","www.montgromerycolleg.edu","Mont","school");
        employerRepository.save(employer);

//        CandidateResume candidateResume = new CandidateResume("Jack","b","Francios","NYU", "Accounting","Amtrak","j@gmail.com","BS","Accounting","2010","Juinor Accountant","2012-2014","Tax preperation");
//        candidateResumeRepository.save(candidateResume);



    }

}