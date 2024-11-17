package org.devajayantha.springform.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

@Setter
@Getter
public class UserAnswerResponse {
    private Date date;
    private UserResponse user;
    private Map<String, String> answers;

    public UserAnswerResponse(Date date, UserResponse user, Map<String, String> answers) {
        this.date = date;
        this.user = user;
        this.answers = answers;
    }
}
