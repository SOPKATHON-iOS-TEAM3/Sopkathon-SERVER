package sopkathon.mobile3.userchoice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopkathon.mobile3.answer.domain.Answer;
import sopkathon.mobile3.answer.repository.AnswerRepository;
import sopkathon.mobile3.common.dto.SuccessStatusResponse;
import sopkathon.mobile3.common.dto.message.ErrorMessage;
import sopkathon.mobile3.common.dto.message.SuccessMessage;
import sopkathon.mobile3.exception.NotFoundException;
import sopkathon.mobile3.member.domain.Member;
import sopkathon.mobile3.member.repository.MemberRepository;
import sopkathon.mobile3.member.service.dto.UserChoiceCreateRequestDto;
import sopkathon.mobile3.question.domain.Question;
import sopkathon.mobile3.question.repository.QuestionRepository;
import sopkathon.mobile3.quiz.domain.Quiz;
import sopkathon.mobile3.userchoice.domain.UserChoice;
import sopkathon.mobile3.userchoice.repository.UserChoiceRepository;

@Service
@RequiredArgsConstructor
public class UserChoiceService {

    private final UserChoiceRepository userChoiceRepository;
    private final AnswerRepository answerRepository;
    private final MemberRepository memberRepository;
    private final QuestionRepository questionRepository;

    @Transactional
    public SuccessStatusResponse createUserChoice(UserChoiceCreateRequestDto requestDto) {

        Member findMember = memberRepository.findById(requestDto.memberId()).orElseThrow(
                () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND)
        );

        Question findQuestion = questionRepository.findById(requestDto.questionId()).orElseThrow(
                () -> new NotFoundException(ErrorMessage.QUESTION_NOT_FOUND)
        );

        Answer findAnswer = answerRepository.findByAnswerIdAndQuestion(requestDto.answerId(), findQuestion)
                .orElseThrow(
                        () -> new NotFoundException(ErrorMessage.ANSWER_NOT_FOUND)
                );

        boolean isCorrect = findAnswer.isCorrect();
        userChoiceRepository.save(UserChoice.create(findMember, findQuestion, findAnswer, isCorrect));

        // 질문을 낸 유저의 friendship_friend 증가
        Quiz quiz = findQuestion.getQuiz();
        Member questionCreator = quiz.getMember();
        if (isLastQuestion(findQuestion)) {
            questionCreator.incrementFriendShipFriend();
            memberRepository.save(questionCreator);
        }

        return SuccessStatusResponse.of(SuccessMessage.ANSWER_CREATE_SUCCESS);
    }

    // 마지막 질문인지 확인하는 메서드
    private boolean isLastQuestion(Question question) {
        return question.getQuestionId() % 3 == 0; // question_id가 3의 배수인지 확인
    }
}