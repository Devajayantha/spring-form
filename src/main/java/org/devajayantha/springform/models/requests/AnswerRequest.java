package org.devajayantha.springform.models.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AnswerRequest {
    @NotNull(message = "The answers field is required.")
    private List<DetailAnswerRequest> answers;
}
