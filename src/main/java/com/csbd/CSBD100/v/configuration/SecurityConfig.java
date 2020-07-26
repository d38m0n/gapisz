package com.csbd.CSBD100.v.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/index/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/user/**").hasAnyAuthority("ROLE_SUPERADMIN")
                .antMatchers("/analyst/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/development-manager/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/resource-manager/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .anyRequest().permitAll()
                .and()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/login-process")
                .failureUrl("/login?error")
                .defaultSuccessUrl("/index")
                .and()
                .logout().logoutSuccessUrl("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("User")
                .password(passwordEncoder.encode("a"))
                .roles("USER")
                .and()
                .withUser("SuperAdmin")
                .password(passwordEncoder.encode("s"))
                .roles("USER", "ADMIN","SUPERADMIN");
        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT login, password, 1 from USER_ENTITY where login=?")
                .authoritiesByUsernameQuery("SELECT login, role, 1, from USER_ENTITY  where login=?")
                .dataSource(jdbcTemplate.getDataSource())
                .passwordEncoder(passwordEncoder);
    }
}
