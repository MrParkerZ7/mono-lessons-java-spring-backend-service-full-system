package com.park.backend.restful.service.backendrestfulservice.config;

import com.park.backend.restful.service.backendrestfulservice.repository.PersonRepository;
import com.park.backend.restful.service.backendrestfulservice.service.CustomPersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableMongoRepositories(basePackageClasses = PersonRepository.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomPersonDetailsService personDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(personDetailsService)
                .passwordEncoder(getPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/server/rest/home").permitAll()
                .antMatchers("/server/rest/profile").authenticated()
                .antMatchers("/server/rest/user").authenticated()
                .antMatchers("/server/rest/admin").authenticated()
                .and().formLogin()//.loginPage("/***.html")
                .loginProcessingUrl("/login").defaultSuccessUrl("/rest/profile")
                .failureUrl("/rest/fail")
                .and().logout().logoutSuccessUrl("/rest/home").permitAll();
    }

    private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return true;
            }
        };
    }

}
