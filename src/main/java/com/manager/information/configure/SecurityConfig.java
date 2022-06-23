//package com.manager.information.configure;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
///**
// * Created by IntelliJ IDEA.
// * Project : spring-boot-security-example
// * User: hendisantika
// * Email: hendisantika@gmail.com
// * Telegram : @hendisantika34
// * Date: 9/29/17
// * Time: 10:10 AM
// * To change this template use File | Settings | File Templates.
// */
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//
////@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Override
//    public void configure(final WebSecurity web) {
//        web.ignoring().antMatchers(HttpMethod.OPTIONS);
//    }
//
//
//    @Bean
//    public FilterRegistrationBean processCorsFilter() {
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        final CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("'");
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        source.registerCorsConfiguration("/**", config);
//
//
//        final FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter((CorsConfigurationSource) source));
//        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        return bean;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/", "/public/**").permitAll()
//                .antMatchers("/users/**").hasAuthority("ADMIN")
//                .anyRequest().fullyAuthenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .failureUrl("/login?error")
//                .usernameParameter("email")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .deleteCookies("remember-me")
//                .logoutSuccessUrl("/")
//                .permitAll()
//                .and()
//                .rememberMe();
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(new BCryptPasswordEncoder());
//    }
//
//}
