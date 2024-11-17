package org.devajayantha.springform.models.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

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
}
