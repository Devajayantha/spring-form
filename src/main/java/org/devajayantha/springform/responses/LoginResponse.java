package org.devajayantha.springform.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponse {
    private String name;
    private String email;
    private String accessToken;

    public LoginResponse(String name, String email, String accessToken) {
        this.name = name;
        this.email = email;
        this.accessToken = accessToken;
    }
}
