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

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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

    @RequestMapping("/")
    public String Main() {
        return "searchlisting";
    }


    @RequestMapping("/login")
    public String login() {

        return "login";
    }



    @GetMapping("/addResume")
    public String addResume(Model model){
        CandidateResume candidateResume = new CandidateResume();
        model.addAttribute("resume", candidateResume);
        return "addresume";
    }

    @PostMapping("/addResume")
    public String addResume(@ModelAttribute("resume") CandidateResume candidateResume){
        candidateResumeRepository.save(candidateResume);
        return "redirect:/";
    }



    @PostMapping("/showresume")
    public String showResume(@ModelAttribute("resume") Model model,CandidateResume candidateResume){
        model.addAttribute("resume",candidateResume);
        return "showresume";
    }

    @GetMapping("/register")
    public String registerGet(Model model) {
        Candidate candidate = new Candidate();
        Employer employer = new Employer();
        UserData userData = new UserData();
        model.addAttribute("employer", employer);
        model.addAttribute("candidate", candidate);
        model.addAttribute("user",userData);
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
        return "candidate_profile";
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
        return "employer_signup";
    }

    @PostMapping("/addemployer")
    public String addEmployer(@ModelAttribute("employer") Employer employer){
        employerRepository.save(employer);
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


}
