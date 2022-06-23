package com.manager.information.security;

import com.manager.information.configure.EmployeeAuthenticationSuccessHandler;
import com.manager.information.service.CustomerUserDetailsService;
import com.manager.information.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Autowired
    private DataSource dataSource;
    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomerUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private MyUserDetailsService userDetailsService;
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService());
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        String loginPage = "/login";
        String logoutPage = "/logout";

        http.
                authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(loginPage).permitAll()
                .antMatchers("/activityForm").permitAll()
                .antMatchers("/api-registeruser").permitAll()
                .antMatchers("viewActivity").permitAll()
                .antMatchers("/book").permitAll()
                .antMatchers("/about").permitAll()
                .antMatchers("/forgot").permitAll()
                .antMatchers("/api/admin").permitAll()
                .antMatchers("/test").permitAll()
                .antMatchers("admin/home").permitAll()
                .antMatchers("/ShowTestimonial").permitAll()
                .antMatchers("/admin/**").permitAll()
                .antMatchers("/viewUserRegister").permitAll()
                .antMatchers("/userDashboard").permitAll()
                .antMatchers("/viewActivity").permitAll()
                .anyRequest()
                .authenticated()
                .and().csrf().disable()
                .formLogin()
                .loginPage(loginPage)
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/userDashboard", true)
                .loginPage("/")
                .failureUrl("/login?error=true")
                .usernameParameter("user_name")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher(logoutPage))
                .logoutSuccessUrl(loginPage).and().exceptionHandling();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

}