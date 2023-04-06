package backend.pet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public InMemoryUserDetailsManager detailsManager(BCryptPasswordEncoder bCryptPasswordEncoder){
        final var owner = User.withUsername("shop_owner@123")
        .password(bCryptPasswordEncoder.encode("owner123"))
        .roles("admin").build();
        
        final var user = User.withUsername("customer")
        .password(bCryptPasswordEncoder.encode("customer123"))
        .roles("user").build(); 

        return new InMemoryUserDetailsManager(owner,user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.csrf().disable()
        .authorizeHttpRequests().requestMatchers(HttpMethod.POST,"/pets").hasRole("admin")
        .anyRequest().permitAll()
        .and().headers().frameOptions().disable()
        .and().httpBasic()
        .and().build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
