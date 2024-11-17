package org.devajayantha.springform.responses;

import lombok.Getter;
import lombok.Setter;
import org.devajayantha.springform.models.entities.Question;

import java.util.List;

@Setter
@Getter
public class DetailFormResponse {
    private Long id;
    private String name;
    private String slug;
    private String description;
    private Boolean limit_one_response;
    private Long creator_id;
    private List<QuestionResponse> questions;

    public DetailFormResponse(Long id, String name, String slug, String description, Boolean limit_one_response, Long creator_id, List<Question> questions) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.limit_one_response = limit_one_response;
        this.creator_id = creator_id;
        this.questions = questions.stream()
                .map(question -> new QuestionResponse(
                        question.getId(),
                        id,
                        question.getName(),
                        question.getChoiceType(),
                        question.getRequired(),
                        question.getChoices()
                )).toList();
    }
}
