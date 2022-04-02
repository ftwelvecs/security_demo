package kz.f12.school.securitydemo.config;

import kz.f12.school.securitydemo.enums.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/store")
                    .hasAnyRole(Role.ADMIN.name(), Role.USER.name())
                .antMatchers(HttpMethod.PUT, "/store")
                    .hasAnyRole(Role.ADMIN.name())
                .antMatchers("/").permitAll()
                .and()
                .httpBasic()
                .and()
                .formLogin();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("123"))
                        .roles(Role.ADMIN.name())
                        .build(),
                User.builder()
                        .username("user")
                        .password(passwordEncoder().encode("123"))
                        .roles(Role.USER.name())
                        .build()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
