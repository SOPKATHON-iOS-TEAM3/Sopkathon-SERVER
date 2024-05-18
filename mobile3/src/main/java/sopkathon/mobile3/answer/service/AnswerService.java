package sopkathon.mobile3.answer.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopkathon.mobile3.answer.domain.Answer;
import sopkathon.mobile3.answer.repository.AnswerRepository;
import sopkathon.mobile3.answer.service.dto.AnswerCreateRequest;
import sopkathon.mobile3.answer.service.dto.AnswerDto;
import sopkathon.mobile3.quiz.domain.Quiz;
import sopkathon.mobile3.quiz.repository.QuizRepository;
import sopkathon.mobile3.question.domain.Question;
import sopkathon.mobile3.question.service.QuestionService;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionService questionService;
    private final QuizRepository quizRepository;

    @Transactional
    public String createAnswers(AnswerCreateRequest answerCreateRequest) {
        Question question = questionService.findById(answerCreateRequest.questionId());

        String inviteCode = null;
        for (AnswerDto answerDto : answerCreateRequest.answers()) {
            Answer answer = Answer.create(answerDto.answerText(), answerDto.isCorrect(), question);
            answer = answerRepository.save(answer);

            if (answer.getAnswerId() % 6 == 0) {
                inviteCode = generateInviteCode();
                Quiz quiz = question.getQuiz();
                quiz.setInviteCode(inviteCode);
                quizRepository.save(quiz);
            }
        }

        return inviteCode;
    }

    private String generateInviteCode() {
        Random random = new Random();
        int randomNumber = random.nextInt(10000);
        return String.format("%04d", randomNumber);
    }
}
