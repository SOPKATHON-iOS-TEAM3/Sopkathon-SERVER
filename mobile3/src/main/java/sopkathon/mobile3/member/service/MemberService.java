package sopkathon.mobile3.member.service;

import com.sun.net.httpserver.Authenticator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopkathon.mobile3.common.dto.SuccessStatusResponse;
import sopkathon.mobile3.common.dto.message.SuccessMessage;
import sopkathon.mobile3.member.domain.Member;
import sopkathon.mobile3.member.repository.MemberRepository;
import sopkathon.mobile3.member.service.dto.MemberCreateRequestDto;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public SuccessStatusResponse create(MemberCreateRequestDto requestDto) {
        memberRepository.save(Member.create(requestDto.nickName(), requestDto.targetFriend()));
        return SuccessStatusResponse.of(SuccessMessage.MEMBER_CREATE_SUCCESS);
    }
}
