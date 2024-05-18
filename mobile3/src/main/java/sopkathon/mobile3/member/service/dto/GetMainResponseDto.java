package sopkathon.mobile3.member.service.dto;

import sopkathon.mobile3.member.domain.Member;

public record GetMainResponseDto(Long memberId, int targetFriend,String nickName) {

    public static GetMainResponseDto of(Member member) {
        return new GetMainResponseDto(member.getMemberId(), member.getTargetFriend() - member.getFriendShipFriend()
        ,member.getNickName());
    }
}
