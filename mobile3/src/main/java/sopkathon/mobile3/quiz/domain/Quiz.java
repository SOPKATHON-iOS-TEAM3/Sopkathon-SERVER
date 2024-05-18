package sopkathon.mobile3.quiz.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import sopkathon.mobile3.member.domain.Member;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizId;

    private String inviteCode;

    @OneToOne
    @JoinColumn(name = "member_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;

    @Builder
    private Quiz(String inviteCode, Member member) {
        this.inviteCode = inviteCode;
        this.member = member;
    }

    public static Quiz create(String inviteCode, Member member) {
        return Quiz.builder()
                .inviteCode(inviteCode)
                .member(member)
                .build();
    }
}
