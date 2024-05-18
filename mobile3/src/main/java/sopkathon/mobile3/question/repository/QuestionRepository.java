package sopkathon.mobile3.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopkathon.mobile3.question.domain.Question;
import sopkathon.mobile3.quiz.domain.Quiz;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByQuiz(Quiz quiz);
}
