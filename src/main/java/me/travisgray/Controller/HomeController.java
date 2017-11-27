package me.travisgray.Controller;

import me.travisgray.Entity.*;
import me.travisgray.Repository.*;
import me.travisgray.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by ${TravisGray} on 11/24/2017.
 */
@Controller
public class HomeController {

    @Autowired
    CandidateRepository candidateRepository;


    @Autowired
    EmployerRepository employerRepository;

    @Autowired
    CandidateResumeRepository candidateResumeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;


    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerGet(Model model) {
        Candidate candidate = new Candidate();
        Employer employer = new Employer();
        model.addAttribute("employer", employer);
        model.addAttribute("candidate", candidate);
        return "register";
    }


    @PostMapping("/register")
    public String processRegistration(@Valid @ModelAttribute("newUser") UserData user,
                                      BindingResult bindingResult, Model model,
                                      @RequestParam(value = "selectedRole") String role) {

        // always add the incoming user back to the model
        model.addAttribute("newUser", user);

        if (bindingResult.hasErrors()) {
            if (userRepository.countByUsername(user.getUsername()) > 0) {
                // in addition to other validation errors, the selected username already exists, so display
                // a custom error message
                model.addAttribute("usernameAlreadyExists", true);
            }
            return "register";

        }
        return "login";
    }

    @GetMapping("/addcandidate")
    public String addCandidate(Model model){
        Candidate candidate = new Candidate();
        model.addAttribute("candidate",candidate);
        return "candidate_profile.html";
    }

    @PostMapping("/addcandidate")
    public String addCandidate(@ModelAttribute("candidate") Candidate candidate){
        candidateRepository.save(candidate);
        return "redirect:/";
    }


    @GetMapping("/addemployer")
    public String addEmployer(Model model){
        Employer employer = new Employer();
        model.addAttribute("employer", employer);
        return "employer_signup.html";
    }

    @PostMapping("/addemployer")
    public String addEmployer(@ModelAttribute("employer") Employer employer){
        employerRepository.save(employer);
        return "redirect:/";
    }

    @GetMapping("/addResume")
    public String addResume(Model model){
        CandidateResume candidateResume = new CandidateResume();
        model.addAttribute("resume", candidateResume);
        return "candidate_add_resume.html";
    }

    @PostMapping("/addResume")
    public String addResume(@ModelAttribute("resume") CandidateResume candidateResume){
        candidateResumeRepository.save(candidateResume);
        return "redirect:/";
    }

    @RequestMapping ("/searchfirstname")
    public String doSearchByFirst(@RequestParam("first") String first, Model model) {
        model.addAttribute(candidateResumeRepository.findAllByFirst(first));

        return "searchlisting";
    }
    @RequestMapping ("/searchlastname")
    public String doSearchByLast(@RequestParam("last") String last, Model model) {
        model.addAttribute(candidateResumeRepository.findAllByLast(last));

        return "searchlisting";
    }


    @RequestMapping ("/searchschool")
    public String doSearchBySchool(@RequestParam("school") String school, Model model) {
        model.addAttribute(candidateResumeRepository.findAllBySchool(school));
        return "searchlisting";
    }

    @RequestMapping ("/dosearchbycompany")
    public String doSearchByCompany(@RequestParam("company") String company, Model model) {
        model.addAttribute(candidateResumeRepository.findAllByCompany(company));
        return "searchlisting";
    }


    @RequestMapping ("/searchskill")
    public String doSearchBySkill(@RequestParam("skill") String skill, Model model) {
        model.addAttribute(candidateResumeRepository.findAllBySkill(skill));
        return "searchlisting";
    }

//    @RequestMapping(value = "/signup", method = RequestMethod.GET)
//    public String signup(Model model){
//
//        //Adding both Candidates and Employers to Model binding to new Variable within Model
//        Candidate candidate = new Candidate();
//        Employer employer = new Employer();
//        Job job = new Job();
//        CandidateResume candidateResume = new CandidateResume();
//
//        model.addAttribute("employer", employer);
//        model.addAttribute("job",job);
//        model.addAttribute("candidateresmue",candidateResume);
//        model.addAttribute("candidate",candidate);
//
////        When we return to signup page we will have a new canidate object defined
//        return "signup";
//
//    }
//
//    @RequestMapping(value = "/signup", method = RequestMethod.POST)
//    public void signupPost(@ModelAttribute("candidate") Candidate candidate, @ModelAttribute("employer") Employer employer, Model model){
//
//    }
//
//

//
//    @GetMapping("/addjob")
//    public String addJob(Model model){
//        Job job = new Job();
//        model.addAttribute("job", job);
//        return "employer_post_job.html";
//    }
//
//    @PostMapping("/addjob")
//    public String addjob(@ModelAttribute("job") Job job){
//        jobRepository.save(job);
//        return "redirect:/";
//    }
//
//    @GetMapping("/addResume")
//    public String addResume(Model model){
//        CandidateResume candidateResume = new CandidateResume();
//        model.addAttribute("resume", candidateResume);
//        return "candidate_add_resume.html";
//    }
//
//    @PostMapping("/addResume")
//    public String addResume(@ModelAttribute("resume") CandidateResume candidateResume){
//        candidateResumeRepository.save(candidateResume);
//        return "redirect:/";
//    }


}
