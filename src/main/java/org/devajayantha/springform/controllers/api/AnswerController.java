package org.devajayantha.springform.controllers.api;

import jakarta.validation.Valid;
import org.devajayantha.springform.models.requests.AnswerRequest;
import org.devajayantha.springform.responses.ApiResponse;
import org.devajayantha.springform.responses.UserAnswerResponse;
import org.devajayantha.springform.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/form/{slug}/answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @PostMapping
    public ApiResponse createAnswer(@PathVariable String slug, @Valid @RequestBody AnswerRequest answerRequest) {
        answerService.createAnswer(slug, answerRequest);

        return ApiResponse.success("Submit response success", null);
    }

    @GetMapping
    public ApiResponse<List<UserAnswerResponse>> getAllAnswers(@PathVariable String slug) {
        return ApiResponse.success("Get responses success", answerService.getAllAnswers(slug));
    }
}
