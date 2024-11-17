package org.devajayantha.springform.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.transaction.Transactional;
import org.devajayantha.springform.models.entities.Answer;
import org.devajayantha.springform.models.entities.Form;
import org.devajayantha.springform.models.entities.Question;
import org.devajayantha.springform.models.entities.User;
import org.devajayantha.springform.models.requests.AnswerRequest;
import org.devajayantha.springform.models.requests.DetailAnswerRequest;
import org.devajayantha.springform.repositories.AnswerRepository;
import org.devajayantha.springform.repositories.FormRepository;
import org.devajayantha.springform.repositories.QuestionRepository;
import org.devajayantha.springform.repositories.UserRepository;
import org.devajayantha.springform.responses.UserAnswerResponse;
import org.devajayantha.springform.responses.UserResponse;
import org.devajayantha.springform.utils.UserSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSupport userSupport;

    @Transactional
    public void createAnswer(String slug, AnswerRequest answerRequest) {
        List<Map<String, Object>> mappedAnswers = new ArrayList<>();
        List<DetailAnswerRequest> listAnswer = answerRequest.getAnswers();
        Form form = formRepository.findBySlug(slug).orElseThrow( () -> new IllegalArgumentException("Form not found"));

        if (listAnswer != null || listAnswer.isEmpty()) {
            for (DetailAnswerRequest detailAnswerRequest : listAnswer) {
                System.out.println(detailAnswerRequest.getQuestion_id());

                Long questionId = detailAnswerRequest.getQuestion_id();
                String value = detailAnswerRequest.getValue();

                String questionName = questionRepository.findById(questionId).map(Question::getName)
                        .orElseThrow(() -> new RuntimeException("Question not found"));

                Map<String, Object> answerData = Map.of(
                        "id", questionId,
                        "name", questionName,
                        "value", value
                );

                mappedAnswers.add(answerData);
            }

            try {
                String response = objectMapper.writeValueAsString(mappedAnswers);

                Answer answer = new Answer(
                        response,
                        form,
                        userSupport.getCurrentUser()
                );

                answerRepository.save(answer);

            } catch (Exception e) {
                throw new RuntimeException("Failed to process answers", e);
            }
        }
    }

    public List<UserAnswerResponse>getAllAnswers(String slug) {
        Form form = formRepository.findBySlug(slug).orElseThrow( () -> new IllegalArgumentException("Form not found"));

        List<Answer> answers = answerRepository.findByFormId(form.getId());

        List<UserAnswerResponse> detailedAnswers = answers.stream()
                .map(answer -> {
                    try {
                        String jsonResponse = answer.getResponse();
                        List<Map<String, Object>> answerList = objectMapper.readValue(
                                jsonResponse, new TypeReference<List<Map<String, Object>>>() {});

                        // Map "name" to "value"
                        Map<String, String> mappedResponse = answerList.stream()
                                .collect(Collectors.toMap(
                                        item -> (String) item.get("name"),
                                        item -> (String) item.get("value")
                                ));


                        User user = userRepository.findById(answer.getCreatedBy().getId())
                                .orElseThrow(() -> new IllegalArgumentException("User not found for ID: " + answer.getCreatedBy().getId()));

                        UserResponse userResponse = new UserResponse(
                                user.getId(),
                                user.getName(),
                                user.getEmail()
                        );

                        return new UserAnswerResponse(answer.getCreatedAt(), userResponse, mappedResponse);
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to parse response JSON for Answer ID: " + answer.getId(), e);
                    }
                })
                .collect(Collectors.toList());

        return detailedAnswers;
    }
}
