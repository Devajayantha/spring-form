package org.devajayantha.springform.repositories;

import org.devajayantha.springform.models.entities.Form;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormRepository extends JpaRepository<Form, Long> {
    Form save(Form form);
    Optional<Form> findBySlug(String slug);
}
