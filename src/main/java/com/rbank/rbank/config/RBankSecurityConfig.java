package com.rbank.rbank.config;


import com.rbank.rbank.filter.CsrfCookieFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.csrf.CsrfTokenRequestHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Configuration
public class RBankSecurityConfig {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler csrfTokenRequestAttributeHandler = new CsrfTokenRequestAttributeHandler();
        csrfTokenRequestAttributeHandler.setCsrfRequestAttributeName("_csrf");


        http.securityContext().requireExplicitSave(false)
                .and().sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .cors().configurationSource(
                        new CorsConfigurationSource() {
                            @Override
                            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                                CorsConfiguration corsConfiguration = new CorsConfiguration();
                                corsConfiguration.setAllowedOrigins(List.of("http://localhost:3000"));
                                corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
                                corsConfiguration.setAllowedHeaders(List.of("*"));
                                corsConfiguration.setAllowCredentials(true);
                                corsConfiguration.setMaxAge(3600L);
                                return corsConfiguration;
                            }
                        }
                ).and()
                .csrf(
                        (csrf) -> csrf
                                .csrfTokenRequestHandler(csrfTokenRequestAttributeHandler)
                                .ignoringRequestMatchers("/contact/**", "/register")
                                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests()
                .requestMatchers("/account/**").hasAuthority("VIEWACCOUNT")
                .requestMatchers("/balance/**").hasAnyAuthority("VIEWACCOUNT","VIEWBALANCE")
                .requestMatchers("/loans/**").hasAuthority("VIEWLOANS")
                .requestMatchers("/cards/**").hasAuthority("VIEWCARDS")
                .requestMatchers("/user").authenticated()
                .requestMatchers("/notices/**", "/contact/**", "/register").permitAll()
                .and().formLogin()
                .and().httpBasic();
        return http.build();
    }



//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin")
//                .authorities("ROLE_ADMIN")
//                .build();
//
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("user")
//                .authorities("ROLE_USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin, user);
//    }
}
