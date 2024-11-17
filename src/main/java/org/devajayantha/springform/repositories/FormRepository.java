package org.devajayantha.springform.repositories;

import org.devajayantha.springform.models.entities.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form, Long> {
    Form save(Form form);
}
