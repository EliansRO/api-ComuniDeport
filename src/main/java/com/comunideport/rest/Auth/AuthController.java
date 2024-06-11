package com.comunideport.rest.Auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.comunideport.rest.Entities.User;
import com.comunideport.rest.Service.IUserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IUserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        try {
            userService.authenticate(email, password);
            return ResponseEntity.ok("Login successful");
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam String email, @RequestParam String password) {
        try {
            userService.register(email, password);
            return ResponseEntity.ok("Registration successful");
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
