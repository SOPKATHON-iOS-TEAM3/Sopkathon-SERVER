package sopkathon.mobile3.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopkathon.mobile3.common.dto.message.ErrorMessage;
import sopkathon.mobile3.exception.NotFoundException;
import sopkathon.mobile3.member.domain.Member;
import sopkathon.mobile3.member.repository.MemberRepository;
import sopkathon.mobile3.member.service.dto.GetMainResponseDto;
import sopkathon.mobile3.member.service.dto.MemberCreateRequestDto;
import sopkathon.mobile3.member.service.dto.MemberCreateResponseDto;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberCreateResponseDto create(MemberCreateRequestDto requestDto) {
        Member findMember = memberRepository.save(Member.create(requestDto.nickName(), requestDto.targetFriend()));
        return new MemberCreateResponseDto(findMember.getMemberId());
    }

    public GetMainResponseDto findMain(Long memberId) {
        return GetMainResponseDto.of(memberRepository.findById(memberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND)
        ));
    }

    public Member findById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(
                () -> new NotFoundException((ErrorMessage.MEMBER_NOT_FOUND))
        );
    }
}