package sopkathon.mobile3.member.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopkathon.mobile3.common.dto.SuccessStatusResponse;
import sopkathon.mobile3.member.service.MemberService;
import sopkathon.mobile3.member.service.dto.GetMainRequestDto;
import sopkathon.mobile3.member.service.dto.GetMainResponseDto;
import sopkathon.mobile3.member.service.dto.MemberCreateRequestDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    @Operation(summary = "닉네임과 친해지고픈 친구 필드를 이용해 멤버를 생성하는 API", description = "닉네임과 친해지고픈 친구 필드를 이용해 멤버를 생성합니다")
    public ResponseEntity<SuccessStatusResponse> createMember(@RequestBody MemberCreateRequestDto requestDto) {
        return ResponseEntity.ok(memberService.create(requestDto));
    }

    @GetMapping("/main")
    public ResponseEntity<GetMainResponseDto> getMain(@RequestBody GetMainRequestDto requestDto) {
        return ResponseEntity.ok(memberService.findMain(requestDto));
    }
}
