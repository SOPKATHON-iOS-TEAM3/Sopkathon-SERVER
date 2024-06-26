package sopkathon.mobile3.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopkathon.mobile3.shared.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false)
    String nickName;

    @Column(nullable = false)
    int targetFriend;

    @Column(nullable = false)
    int friendShipFriend;

    public static Member create(String nickName, int targetFriend) {
        return Member.builder()
                .nickName(nickName)
                .targetFriend(targetFriend)
                .build();
    }

    @Builder
    private Member(String nickName, int targetFriend) {
        this.nickName = nickName;
        this.targetFriend = targetFriend;
    }

    public void incrementFriendShipFriend() {
        this.friendShipFriend += 1;
    }
}