package sopkathon.mobile3.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopkathon.mobile3.common.dto.SuccessStatusResponse;
import sopkathon.mobile3.member.service.MemberService;
import sopkathon.mobile3.member.service.dto.MemberCreateRequestDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("")
    public ResponseEntity<SuccessStatusResponse> createMember(@RequestBody MemberCreateRequestDto requestDto) {
        return ResponseEntity.ok(memberService.create(requestDto));
    }
}
