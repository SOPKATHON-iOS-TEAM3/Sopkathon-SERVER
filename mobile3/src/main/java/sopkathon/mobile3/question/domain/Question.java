package sopkathon.mobile3.question.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import sopkathon.mobile3.quiz.domain.Quiz;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    private String questionText;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Quiz quiz;

    @Builder
    private Question(String questionText, Quiz quiz) {
        this.questionText = questionText;
        this.quiz = quiz;
    }

    public static Question create(String questionText, Quiz quiz) {
        return Question.builder()
                .questionText(questionText)
                .quiz(quiz)
                .build();
    }
}
