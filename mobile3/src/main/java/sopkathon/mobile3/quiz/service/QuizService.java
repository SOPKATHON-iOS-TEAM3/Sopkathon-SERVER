package sopkathon.mobile3.quiz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopkathon.mobile3.answer.domain.Answer;
import sopkathon.mobile3.answer.repository.AnswerRepository;
import sopkathon.mobile3.common.dto.message.ErrorMessage;
import sopkathon.mobile3.exception.NotFoundException;
import sopkathon.mobile3.member.domain.Member;
import sopkathon.mobile3.member.service.MemberService;
import sopkathon.mobile3.question.domain.Question;
import sopkathon.mobile3.question.repository.QuestionRepository;
import sopkathon.mobile3.quiz.domain.Quiz;
import sopkathon.mobile3.quiz.repository.QuizRepository;
import sopkathon.mobile3.quiz.service.dto.FindAnswerDto;
import sopkathon.mobile3.quiz.service.dto.FindQuestionDto;
import sopkathon.mobile3.quiz.service.dto.FindQuizRequestDto;
import sopkathon.mobile3.quiz.service.dto.FindQuizResponseDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;
    private final MemberService memberService;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    @Transactional
    public String createQuiz(Long memberId) {
        Member member = memberService.findById(memberId);
        Quiz quiz = quizRepository.save(Quiz.create(null, member));
        return quiz.getQuizId().toString();
    }

    public FindQuizResponseDto findQuizByInvitationCode(String inviteCode) {
        Quiz findQuiz = quizRepository.findQuizByInviteCode(inviteCode).orElseThrow(
                () -> new NotFoundException(ErrorMessage.QUIZ_NOT_FOUND)
        );

        List<Question> questionList = questionRepository.findByQuiz(findQuiz);
        List<Answer> answerList = new ArrayList<>();
        for (Question question : questionList) {
            answerList.addAll(answerRepository.findByQuestion(question));
        }

        List<FindQuestionDto> questionDtos = questionList.stream().map(
                FindQuestionDto::of
        ).collect(Collectors.toList());

        List<FindAnswerDto> answerDtos = answerList.stream().map(
                FindAnswerDto::of
        ).collect(Collectors.toList());

        return new FindQuizResponseDto(questionDtos, answerDtos);
    }

    public Quiz findById(Long quizId) {
        return quizRepository.findById(quizId).orElseThrow(
                () -> new NotFoundException((ErrorMessage.QUIZ_NOT_FOUND))
        );
    }
}
