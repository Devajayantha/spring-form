package org.devajayantha.springform.services;

import org.devajayantha.springform.models.entities.Form;
import org.devajayantha.springform.models.requests.FormRequest;
import org.devajayantha.springform.repositories.FormRepository;
import org.devajayantha.springform.utils.UserSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService {
    @Autowired
    private FormRepository formRepository;

    @Autowired
    private UserSupport userSupport;

    public Form createForm(FormRequest formRequest) {
        Form form = new Form(
            formRequest.getName(),
            formRequest.getSlug(),
            formRequest.getDescription(),
            formRequest.getIs_one_response(),
                userSupport.getCurrentUser()
        );

        return formRepository.save(form);
    }
}
