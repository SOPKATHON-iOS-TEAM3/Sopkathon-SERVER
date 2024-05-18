package sopkathon.mobile3.quiz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopkathon.mobile3.common.dto.message.ErrorMessage;
import sopkathon.mobile3.exception.NotFoundException;
import sopkathon.mobile3.member.domain.Member;
import sopkathon.mobile3.member.service.MemberService;
import sopkathon.mobile3.quiz.domain.Quiz;
import sopkathon.mobile3.quiz.repository.QuizRepository;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;
    private final MemberService memberService;

    @Transactional
    public String createQuiz(Long memberId) {
        Member member = memberService.findById(memberId);
        Quiz quiz = quizRepository.save(Quiz.create(null, member));
        return quiz.getQuizId().toString();
    }

    public Quiz findById(Long quizId) {
        return quizRepository.findById(quizId).orElseThrow(
                () -> new NotFoundException((ErrorMessage.QUIZ_NOT_FOUND))
        );
    }
}
