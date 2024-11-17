package org.devajayantha.springform.repositories;

import org.devajayantha.springform.models.entities.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FormRepository extends JpaRepository<Form, Long> {
    Form save(Form form);
    Optional<Form> findBySlug(String slug);
    List<Form> findByCreatedById(Long createdById);
}
