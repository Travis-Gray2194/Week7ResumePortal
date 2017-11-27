package me.travisgray.Entity;


import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ${TravisGray} on 11/24/2017.
 */
@Entity
public class CandidateResume {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String first;
    private String last;
    private String school;
    private String skill;
    private String company;
    private String email;
    private String degree;
    private String field;
    private String yearGrad;
    private String workTitle;
    private String workDur;
    private String duty;
    private String proficiency;


    public CandidateResume() {
    }

    public CandidateResume(String first, String last, String school, String skill, String company, String email, String degree, String field, String yearGrad, String workTitle, String workDur, String duty, String proficiency) {
        this.first = first;
        this.last = last;
        this.school = school;
        this.skill = skill;
        this.company = company;
        this.email = email;
        this.degree = degree;
        this.field = field;
        this.yearGrad = yearGrad;
        this.workTitle = workTitle;
        this.workDur = workDur;
        this.duty = duty;
        this.proficiency = proficiency;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "candidate_id"), inverseJoinColumns = @JoinColumn(name = "resume_id"))
    private Collection<Candidate>candidates;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }


    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getYearGrad() {
        return yearGrad;
    }

    public void setYearGrad(String yearGrad) {
        this.yearGrad = yearGrad;
    }

    public String getWorkTitle() {
        return workTitle;
    }

    public void setWorkTitle(String workTitle) {
        this.workTitle = workTitle;
    }

    public String getWorkDur() {
        return workDur;
    }

    public void setWorkDur(String workDur) {
        this.workDur = workDur;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }



}
