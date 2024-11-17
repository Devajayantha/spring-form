package org.devajayantha.springform.controllers.api;

import jakarta.validation.Valid;
import org.devajayantha.springform.models.entities.Form;
import org.devajayantha.springform.models.entities.Question;
import org.devajayantha.springform.models.requests.QuestionRequest;
import org.devajayantha.springform.responses.ApiResponse;
import org.devajayantha.springform.responses.FormResponse;
import org.devajayantha.springform.responses.QuestionResponse;
import org.devajayantha.springform.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/form/{slug}/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ApiResponse<QuestionResponse> createQuestion(@PathVariable String slug, @Valid @RequestBody QuestionRequest questionRequest) {
        Question question = questionService.createQuestion(slug, questionRequest);

        QuestionResponse questionResponse = new QuestionResponse(
                question.getId(),
                question.getForm().getId(),
                question.getName(),
                question.getChoiceType(),
                question.getRequired(),
                question.getChoices()
        );

        return ApiResponse.success("Add question success", questionResponse);
    }
}
