package org.devajayantha.springform.controllers.api;

import jakarta.validation.Valid;
import org.devajayantha.springform.models.entities.Form;
import org.devajayantha.springform.models.requests.FormRequest;
import org.devajayantha.springform.responses.ApiResponse;
import org.devajayantha.springform.responses.FormResponse;
import org.devajayantha.springform.responses.LoginResponse;
import org.devajayantha.springform.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/form")
public class FormController {
    @Autowired
    private FormService formService;

    @PostMapping
    public ApiResponse<FormResponse>  createForm(@Valid @RequestBody FormRequest formRequest) {
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
}
