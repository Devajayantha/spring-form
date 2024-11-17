package org.devajayantha.springform.responses;

import lombok.Getter;
import lombok.Setter;
import org.devajayantha.springform.models.enums.TypeChoice;

import java.util.Arrays;
import java.util.List;

@Setter
@Getter
public class QuestionResponse {
    private Long id;
    private Long form_id;
    private String name;
    private String choice_type;
    private Boolean is_required;
    private List<String> choices;

    public QuestionResponse(Long id, Long form_id, String name, TypeChoice choice_type, Boolean is_required, List<String> choices) {
        this.id = id;
        this.form_id = form_id;
        this.name = name;
        this.choice_type = choice_type.getLabel();
        this.is_required = is_required;
        this.choices = choices;
    }
}
