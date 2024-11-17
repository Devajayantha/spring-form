package org.devajayantha.springform.repositories;

import org.devajayantha.springform.models.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Answer save(Answer answer);
    List<Answer> findByFormId(Long formId);
}
