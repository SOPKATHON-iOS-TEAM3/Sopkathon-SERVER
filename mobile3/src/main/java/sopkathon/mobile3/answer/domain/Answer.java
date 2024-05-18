package sopkathon.mobile3.answer.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import sopkathon.mobile3.question.domain.Question;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    private String answerText;

    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Question question;

    @Builder
    private Answer(String answerText, boolean isCorrect, Question question) {
        this.answerText = answerText;
        this.isCorrect = isCorrect;
        this.question = question;
    }

    public static Answer create(String answerText, boolean isCorrect, Question question) {
        return Answer.builder()
                .answerText(answerText)
                .isCorrect(isCorrect)
                .question(question)
                .build();
    }
}