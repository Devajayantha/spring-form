package org.devajayantha.springform.services;

import org.devajayantha.springform.models.entities.AllowedDomain;
import org.devajayantha.springform.models.entities.Form;
import org.devajayantha.springform.models.requests.FormRequest;
import org.devajayantha.springform.repositories.AllowedDomainRepository;
import org.devajayantha.springform.repositories.FormRepository;
import org.devajayantha.springform.utils.UserSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormService {
    @Autowired
    private FormRepository formRepository;

    @Autowired
    private AllowedDomainRepository allowedDomainRepository;

    @Autowired
    private UserSupport userSupport;

    public List<Form> getAllForms() {
        return formRepository.findByCreatedById(userSupport.getCurrentUser().getId());
    }

    public Form createForm(FormRequest formRequest) {
        Form form = new Form(
            formRequest.getName(),
            formRequest.getSlug(),
            formRequest.getDescription(),
            formRequest.getIs_one_response(),
                userSupport.getCurrentUser()
        );

        Form result = formRepository.save(form);

        List<String> listDomains = formRequest.getAllowed_domains();

        if (listDomains != null || !listDomains.isEmpty()) {
            for (String domain : listDomains) {
                allowedDomainRepository.save(new AllowedDomain(domain, result));
            }
        }

        return formRepository.save(form);
    }

    public Form showForm(String slug) {
        Form form = formRepository.findBySlug(slug).orElseThrow( () -> new IllegalArgumentException("Form not found"));

        return form;
    }
}
