package org.devajayantha.springform.repositories;

import org.devajayantha.springform.models.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Question save(Question question);
}
