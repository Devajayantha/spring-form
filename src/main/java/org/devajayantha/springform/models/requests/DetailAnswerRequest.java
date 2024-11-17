package org.devajayantha.springform.models.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DetailAnswerRequest {
    private Long question_id;
    private String value;
}
