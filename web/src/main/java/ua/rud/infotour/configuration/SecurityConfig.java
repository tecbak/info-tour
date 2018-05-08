package ua.rud.infotour.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ua.rud.infotour.service.PersonService;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final PersonService personService;
    private final DataSource dataSource;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("spring.queries.user")
    private String userQuery;

    @Value("spring.queries.roles")
    private String rolesQuery;

    @Autowired
    public SecurityConfig(PersonService personService, DataSource dataSource
            , BCryptPasswordEncoder bCryptPasswordEncoder
    ) {
        this.personService = personService;
        this.dataSource = dataSource;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").access("hasRole('ROLE_USER')")
                .antMatchers("/**").permitAll()

                .and()
                .logout().logoutSuccessUrl("/login?logout")

                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery(userQuery)
//                .authoritiesByUsernameQuery(rolesQuery)
//                .passwordEncoder(bCryptPasswordEncoder);
        auth
                .userDetailsService(personService::getByName);
    }
}
