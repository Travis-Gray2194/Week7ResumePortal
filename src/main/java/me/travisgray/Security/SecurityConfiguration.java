package me.travisgray.Security;

/**
 * Created by student on 6/23/17.
 */


import me.travisgray.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    @Autowired
    private EmployerRepository employerRepository;
    private CandidateResumeRepository candidateResumeRepository;
    private CandidateRepository candidateRepository;
    private UserRepository userRepository;
    private RoleRepository roleRepository;



    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception{
        return new SSUserDetailsService(userRepository);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests().antMatchers( "/css/**").permitAll()
                .antMatchers("/dosearchbyschool, /dosearchbycompany, /dosearchbyskill").hasRole("RECRUITER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .permitAll()
                .and()
                .httpBasic();

        http
                .csrf().disable();
        http
                .headers().frameOptions().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsServiceBean());
    auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and().
                withUser("root").password("password2").roles("RECRUITER").and().
                withUser("Dave").password("begreat").roles("RECRUITER").and().
        withUser("Fi").password("becold").roles("RECRUITER");
    }
}
