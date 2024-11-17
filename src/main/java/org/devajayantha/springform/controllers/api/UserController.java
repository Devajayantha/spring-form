package org.devajayantha.springform.controllers.api;

import jakarta.validation.Valid;
import org.devajayantha.springform.models.entities.User;
import org.devajayantha.springform.models.requests.LoginRequest;
import org.devajayantha.springform.responses.ApiResponse;
import org.devajayantha.springform.responses.LoginResponse;
import org.devajayantha.springform.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {
    @Autowired
    protected AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        // Authenticate the user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );

        // Generate JWT token
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        // Retrieve user details from the database
        User userDetails = (User) authentication.getPrincipal();

        LoginResponse loginResponse = new LoginResponse(
                userDetails.getName(),
                userDetails.getEmail(),
                jwt
        );

        // If validation passes, handle login logic
        return ApiResponse.success("login successful", loginResponse);
    }
}
