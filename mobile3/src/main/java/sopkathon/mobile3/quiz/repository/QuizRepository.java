package sopkathon.mobile3.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopkathon.mobile3.quiz.domain.Quiz;

import java.util.Optional;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    Optional<Quiz> findQuizByInviteCode(String inviteCode);
}