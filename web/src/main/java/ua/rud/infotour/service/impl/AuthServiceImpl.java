package ua.rud.infotour.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ua.rud.infotour.domain.Person;
import ua.rud.infotour.service.AuthService;

import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public Person whoAmI() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (Person) authentication.getPrincipal();
    }
}
