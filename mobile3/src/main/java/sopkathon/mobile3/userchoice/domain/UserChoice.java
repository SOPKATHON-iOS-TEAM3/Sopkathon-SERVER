package sopkathon.mobile3.userchoice.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopkathon.mobile3.answer.domain.Answer;
import sopkathon.mobile3.member.domain.Member;
import sopkathon.mobile3.question.domain.Question;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserChoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userChoiceId;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "answer_id", nullable = false)
    private Answer answer;

    private boolean isCorrect;
    @Builder
    private UserChoice(Member member, Question question, Answer answer, boolean isCorrect) {
        this.member = member;
        this.question = question;
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    public static UserChoice create(Member member, Question question, Answer answer, boolean isCorrect) {
        return UserChoice.builder()
                .member(member)
                .question(question)
                .answer(answer)
                .isCorrect(isCorrect)
                .build();
    }
}