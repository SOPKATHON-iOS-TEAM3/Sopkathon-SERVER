package sopkathon.mobile3.answer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopkathon.mobile3.answer.domain.Answer;
import sopkathon.mobile3.question.domain.Question;

import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Optional<Answer> findByAnswerIdAndQuestion(Long answerId, Question question);
}
