package iu.edu.frank.demo.controllers;


//
import iu.edu.frank.demo.model.Customer;
import iu.edu.frank.demo.repository.CustomerFileRepository;
import iu.edu.frank.demo.security.TokenService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

@RestController
@CrossOrigin
public class AuthenticationController {
    CustomerFileRepository customerFileRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticationController(CustomerFileRepository
                                            customerFileRepository,
                                    AuthenticationManager authenticationManager,
                                    TokenService tokenService) {
        this.customerFileRepository = customerFileRepository;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }
    @PostMapping("/signup")
    public void signup(@RequestBody Customer customer) {
        try {
            customerFileRepository.save(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/signin")
    public String login(@RequestBody Customer customer) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        customer.getUsername(),
                        customer.getPassword()
                )
        );
        return tokenService.generateToken(authentication);
    }
}