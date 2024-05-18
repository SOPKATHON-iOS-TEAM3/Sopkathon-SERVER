package sopkathon.mobile3.answer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopkathon.mobile3.answer.domain.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
