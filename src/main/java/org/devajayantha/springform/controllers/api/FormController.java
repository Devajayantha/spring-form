package org.devajayantha.springform.controllers.api;

import jakarta.validation.Valid;
import org.devajayantha.springform.models.entities.Form;
import org.devajayantha.springform.models.requests.FormRequest;
import org.devajayantha.springform.responses.ApiResponse;
import org.devajayantha.springform.responses.DetailFormResponse;
import org.devajayantha.springform.responses.FormResponse;
import org.devajayantha.springform.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/form")
public class FormController {
    @Autowired
    private FormService formService;

    @GetMapping
    public ApiResponse<List<FormResponse>> getAllForms(){
        List<Form> forms = formService.getAllForms();

        List<FormResponse> formResponses = forms.stream()
                .map(form -> new FormResponse(
                        form.getId(),
                        form.getName(),
                        form.getSlug(),
                        form.getDescription(),
                        form.getOneResponse(),
                        form.getCreatedBy().getId()
                ))
                .toList();

        return ApiResponse.success("Get all forms success", formResponses);
    }

    @PostMapping
    public ApiResponse<FormResponse> createForm(@Valid @RequestBody FormRequest formRequest) {
        Form form = formService.createForm(formRequest);

        FormResponse formResponse = new FormResponse(
                form.getId(),
                form.getName(),
                form.getSlug(),
                form.getDescription(),
                form.getOneResponse(),
                form.getCreatedBy().getId()
        );

        return ApiResponse.success("Create form success", formResponse);
    }

    @GetMapping("{slug}")
    public ApiResponse<DetailFormResponse> showForm(@PathVariable String slug) {
        Form form = formService.showForm(slug);

        DetailFormResponse detailFormResponse = new DetailFormResponse(
                form.getId(),
                form.getName(),
                form.getSlug(),
                form.getDescription(),
                form.getOneResponse(),
                form.getCreatedBy().getId(),
                form.getQuestions()
        );

        return ApiResponse.success("Get form success", detailFormResponse);
    }
}
