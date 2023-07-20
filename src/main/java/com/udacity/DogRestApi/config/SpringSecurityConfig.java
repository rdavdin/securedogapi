package com.udacity.DogRestApi.config;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.*;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig /*extends WebSecurityConfigurerAdapter*/ {
    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     http
    //             .csrf().disable()
    //             .authorizeRequests()
    //             .anyRequest()
    //             .authenticated()
    //             .and()
    //             .httpBasic();
    // }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf((csrf) -> csrf.disable());
        http.authorizeHttpRequests((authReqs) -> 
            authReqs.anyRequest().authenticated()
        );
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }

    // @Autowired
    // public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

    //     auth.inMemoryAuthentication()
    //             .withUser("admin")
    //             .password(encoder().encode("password"))
    //             .roles("USER");
    // }

    @Bean
    public InMemoryUserDetailsManager  configGlobal() throws Exception {
        UserDetails user = User.withUsername("admin")
                                .password(encoder().encode("password"))
                                .roles("USER")
                                .build();
        
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
