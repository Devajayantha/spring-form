package org.devajayantha.springform.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FormResponse {
    private Long id;
    private String name;
    private String slug;
    private String description;
    private Boolean limit_one_response;
    private Long creator_id;

    public FormResponse(Long id, String name, String slug, String description, Boolean limit_one_response, Long creator_id) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.limit_one_response = limit_one_response;
        this.creator_id = creator_id;
    }
}
