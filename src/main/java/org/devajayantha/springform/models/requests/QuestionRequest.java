package org.devajayantha.springform.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.devajayantha.springform.models.enums.TypeChoice;

import java.util.List;

@Setter
@Getter
public class QuestionRequest {
    @NotBlank(message = "The name field is required.")
    public String name;

    @NotNull(message = "The choice type field is required.")
    public TypeChoice choice_type;

    private List<String> choices;

    public Boolean is_required = Boolean.FALSE;
}
