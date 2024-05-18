package sopkathon.mobile3.answer.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopkathon.mobile3.answer.domain.Answer;
import sopkathon.mobile3.answer.repository.AnswerRepository;
import sopkathon.mobile3.answer.service.dto.AnswerCreateRequest;
import sopkathon.mobile3.question.domain.Question;
import sopkathon.mobile3.question.service.QuestionService;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionService questionService;

    @Transactional
    public void createAnswers(AnswerCreateRequest answerCreateRequest) {
        Question question = questionService.findById(answerCreateRequest.questionId());  // QuestionService의 findById 메서드 사용

        answerCreateRequest.answers().forEach(answerDto -> {
            Answer answer = Answer.create(answerDto.answerText(), answerDto.isCorrect(), question);
            answerRepository.save(answer);
        });
    }
}
