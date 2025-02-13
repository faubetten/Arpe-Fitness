package pt.iade.ArpeFitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.iade.ArpeFitness.service.AuthenticationService;
import pt.iade.ArpeFitness.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    // Endpoint de login
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        boolean authenticated = authenticationService.authenticate(email, password);
        if (authenticated) {
            return "Login bem-sucedido!";
        } else {
            return "Credenciais inválidas!";
        }
    }
}
