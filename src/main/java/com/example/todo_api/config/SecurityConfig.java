////package com.example.todo_api.config;
////
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.Customizer;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.http.SessionCreationPolicy;
////import org.springframework.security.web.SecurityFilterChain;
////
////@Configuration
////@EnableWebSecurity
////public class SecurityConfig {
////	@Bean
////	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////		http.csrf(customizer -> customizer.disable()); // For to Disable CSRF
////		http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
//////		http.formLogin(customizer -> Customizer.withDefaults()); //To get Form
////		http.httpBasic(Customizer.withDefaults()); // TO get acess for Postman
////		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
////		return http.build();
////	}
////	
////}
//
//
////
// //package com.karma.Auth_app.config;
////
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.security.web.SecurityFilterChain;
////
////@Configuration
////@EnableWebSecurity
////public class SecurityConfig {
////
////  @Bean
////  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////      http
////          .csrf().disable()
////          .authorizeRequests()
////          .requestMatchers("/api/auth/signup","/api/tasks/**", "/api/auth/login", "/h2-console/**", "/").permitAll() // Allow these endpoints without authentication
////          .anyRequest().authenticated();
////
////      // Allow H2 console to be accessed without authentication
////      http.headers().frameOptions().disable();
////
////      return http.build();
////  }
////
////  @Bean
////  public PasswordEncoder passwordEncoder() {
////      return new BCryptPasswordEncoder();
////  }
////}
//// C:\Users\anilbabu\Desktop\New folder\Auth-app\src\main\java\com\karma\Auth_app\config\WebConfig.java
//
//
////
////package com.karma.Auth_app.config;
////
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.Customizer;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.security.web.SecurityFilterChain;
////
////@Configuration
////@EnableWebSecurity
////public class SecurityConfig {
////
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http
////            .csrf().disable()
////            .authorizeRequests()
////            .requestMatchers("/","/api/auth/signup", "/api/auth/login", "/api/auth/**", "/h2-console/**", "/").permitAll() // Allow these endpoints without authentication
////            .requestMatchers("/api/tasks/**", "/api/groups/**").permitAll() // Allow access to all task-related endpoints (including POST, PUT, DELETE)
////            .anyRequest().authenticated(); // Require authentication for all other endpoints
////        http.formLogin(Customizer.withDefaults());
////        // Allow H2 console to be accessed without authentication
////        http.headers().frameOptions().disable();
////
////        return http.build();
////    }
////    
//////    		http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
////
////
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
////}
//
//
//
//
////
////package com.example.todo_api.config;
////
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.Customizer;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.http.SessionCreationPolicy;
////import org.springframework.security.web.SecurityFilterChain;
////
////@Configuration
////@EnableWebSecurity
////public class SecurityConfig {
////	@Bean
////	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////		http.csrf(customizer -> customizer.disable());
////		http.authorizeHttpRequests(request -> request.requestMatchers("/").permitAll());
////		http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
////		http.httpBasic(Customizer.withDefaults());
////		http.formLogin(Customizer.withDefaults());
////		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
////		
////		return http.build();
////	}
////}
//
////
////package com.example.todo_api.config;
////
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.authentication.AuthenticationManager;
////import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.core.userdetails.User;
////import org.springframework.security.core.userdetails.UserDetails;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.security.provisioning.InMemoryUserDetailsManager;
////import org.springframework.security.web.SecurityFilterChain;
////
////@Configuration
////public class SecurityConfig {
////
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http.authorizeHttpRequests()
////            .requestMatchers("/user/**").hasRole("USER")
////            .requestMatchers("/admin/**").hasRole("ADMIN")
////            .requestMatchers("/about").permitAll()
////            .anyRequest().authenticated()
////            .and()
////            .formLogin();
////        return http.build();
////    }
////
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder(); // Use BCrypt for production
////    }
////
////    @Bean
////    public InMemoryUserDetailsManager userDetailsService() {
////        UserDetails user1 = User.withUsername("sam")
////            .password(passwordEncoder().encode("sam"))
////            .roles("USER")
////            .build();
////
////        UserDetails user2 = User.withUsername("karma")
////            .password(passwordEncoder().encode("karma"))
////            .roles("ADMIN")
////            .build();
////        
////        UserDetails user3 = User.withUsername("sai")
////            .password(passwordEncoder().encode("sai"))
////            .roles("USER")
////            .build();
////        
////        return new InMemoryUserDetailsManager(user1, user2, user3);
////    }
////
////    @Bean
////    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
////        return authConfig.getAuthenticationManager();
////    }
////}
//
//package com.example.todo_api.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.example.todo_api.service.CompanyUserDetailsService;
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig {
//
//    @Autowired
//    
//    private UserDetailsService userDetailsService;
//    
//    @Autowired
//    private JwtFilter jwtFilter;
//    
//    @Autowired
//    private CompanyUserDetailsService companyUserDetailsService;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable())
//            .authorizeHttpRequests(auth -> {
//                auth.requestMatchers("/company/register","/company/login","/login","/register", "/reset-password", "/forgot-password").permitAll();
//                auth.requestMatchers("/users/**").hasRole("USER");
//                auth.requestMatchers("/admin/**").hasRole("ADMIN");
//                auth.anyRequest().authenticated();
//            })
//            .httpBasic(Customizer.withDefaults())
//            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
//            .cors();
//
//        return http.build();
//    }
//
//    @Bean
//    public AuthenticationProvider userAuthenticationProvider(UserDetailsService myUserDetailsService) {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(passwordEncoder());
//        provider.setUserDetailsService(myUserDetailsService);
//        return provider;
//    }
//
//    @Bean
//    public AuthenticationProvider companyAuthenticationProvider(CompanyUserDetailsService companyUserDetailsService) {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(passwordEncoder());
//        provider.setUserDetailsService(companyUserDetailsService);
//        return provider;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(12);
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//        return authConfig.getAuthenticationManager();
//    }
//}
//
//


package com.example.todo_api.config;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.todo_api.service.CompanyUserDetailsService;
import com.example.todo_api.service.MyUserDetailsService;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;
    
   

    @Autowired
    @Qualifier("myUserDetailsService")  // Use @Qualifier to specify which UserDetailsService to inject
    private UserDetailsService myUserDetailsService;

    @Autowired
    @Qualifier("companyUserDetailsService")
    private UserDetailsService companyUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> {
//                auth.requestMatchers("/company/register", "/company/login", "/login", "/register", "/reset-password", "/forgot-password").permitAll();
//                auth.requestMatchers("/users/**").hasRole("USER");
//                auth.requestMatchers("/admin/**").hasRole("ADMIN");
                auth.anyRequest().permitAll();
            })
            .httpBasic(Customizer.withDefaults())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
            .cors();

        return http.build();
    }

//    @Bean
//    public AuthenticationProvider userAuthenticationProvider(@Qualifier("myUserDetailsService") MyUserDetailsService myUserDetailsService) {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(passwordEncoder());
//        provider.setUserDetailsService(myUserDetailsService);
//        return provider;
//    }
//    
//    @Bean
//    public AuthenticationProvider companyUserAuthenticationProvider(@Qualifier("companyUserDetailsService") CompanyUserDetailsService companyUserDetailsService) {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(passwordEncoder());
//        provider.setUserDetailsService(companyUserDetailsService);
//        return provider;
//    }
    @Bean
    public DaoAuthenticationProvider userAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(myUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public DaoAuthenticationProvider companyAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(companyUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}
