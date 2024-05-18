package sopkathon.mobile3.member.controller;

import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "닉네임과 타겟 필드로 멤버를 생성하는 API", description = "닉네임과 타겟 필드로 멤버를 생성하는 로직을 처리합니다.")
    @PostMapping("")
    public ResponseEntity<SuccessStatusResponse> createMember(@RequestBody MemberCreateRequestDto requestDto) {
        return ResponseEntity.ok(memberService.create(requestDto));
    }
}
