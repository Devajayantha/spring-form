package org.devajayantha.springform.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FormRequest {
    @NotBlank(message = "The name field is required.")
    public String name;

    @NotBlank(message = "The description field is required.")
    public String description;

    @NotBlank(message = "The slug field is required.")
    public String slug;

    public Boolean is_one_response = Boolean.FALSE;

    public List<String> allowed_domains = List.of();
}
