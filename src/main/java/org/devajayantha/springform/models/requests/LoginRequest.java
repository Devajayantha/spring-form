package org.devajayantha.springform.models.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank(message = "The email field is required.")
    @Email(message = "The email must be a valid email address.")
    public String email;

    @NotBlank(message = "The password field is required.")
    public String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
