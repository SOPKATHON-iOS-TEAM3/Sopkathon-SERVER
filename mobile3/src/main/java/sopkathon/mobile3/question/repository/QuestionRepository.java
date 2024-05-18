package sopkathon.mobile3.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopkathon.mobile3.question.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
