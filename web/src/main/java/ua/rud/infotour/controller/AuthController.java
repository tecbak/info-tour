package ua.rud.infotour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.rud.infotour.domain.Person;
import ua.rud.infotour.service.AuthService;

@RestController()
@RequestMapping("auth")
public class AuthController {
    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("whoami")
    public Person whoAmI() {
        return authService.whoAmI();
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("yes")
    public String yes() {
        return "yes";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("no")
    public String no() {
        return "no";
    }
}
