package sopkathon.mobile3.userchoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopkathon.mobile3.userchoice.domain.UserChoice;

public interface UserChoiceRepository extends JpaRepository<UserChoice, Long> {
}
