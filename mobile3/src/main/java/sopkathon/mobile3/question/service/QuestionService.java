package sopkathon.mobile3.question.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import sopkathon.mobile3.common.dto.message.ErrorMessage;
import sopkathon.mobile3.exception.NotFoundException;
import sopkathon.mobile3.question.domain.Question;
import sopkathon.mobile3.question.repository.QuestionRepository;
import sopkathon.mobile3.question.service.dto.QuestionCreateRequest;
import sopkathon.mobile3.quiz.domain.Quiz;
import sopkathon.mobile3.quiz.service.QuizService;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final QuizService quizService;

    public String createQuestion(QuestionCreateRequest questionCreateRequest) {
        Quiz quiz = quizService.findById(questionCreateRequest.quizId());
        Question question = questionRepository.save(Question.create(
                questionCreateRequest.questionText(), quiz));

        return question.getQuestionId().toString();
    }

    public Question findById(Long questionId) {
        return questionRepository.findById(questionId)
                .orElseThrow(() -> new NotFoundException((ErrorMessage.QUESTION_NOT_FOUND)));
    }
}
