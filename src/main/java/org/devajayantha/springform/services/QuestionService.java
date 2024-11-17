package org.devajayantha.springform.services;

import org.devajayantha.springform.models.entities.Form;
import org.devajayantha.springform.models.entities.Question;
import org.devajayantha.springform.models.requests.QuestionRequest;
import org.devajayantha.springform.repositories.FormRepository;
import org.devajayantha.springform.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private FormRepository formRepository;

    public Question createQuestion(String slug, QuestionRequest questionRequest) {
        Form form = formRepository.findBySlug(slug).orElseThrow( () -> new IllegalArgumentException("Form not found"));

        Question question = new Question(
                questionRequest.getName(),
                questionRequest.getChoice_type(),
                questionRequest.getIs_required(),
                form
        );

        question.setChoices(questionRequest.getChoices());

        return questionRepository.save(question);
    }

    public void deleteQuestion(String slug, Long questionId) {
        questionRepository.deleteById(questionId);
    }
}
