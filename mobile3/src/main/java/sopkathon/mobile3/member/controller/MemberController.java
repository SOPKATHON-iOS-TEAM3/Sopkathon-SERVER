package sopkathon.mobile3.member.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopkathon.mobile3.member.service.MemberService;
import sopkathon.mobile3.member.service.dto.GetMainResponseDto;
import sopkathon.mobile3.member.service.dto.MemberCreateRequestDto;
import sopkathon.mobile3.member.service.dto.MemberCreateResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    @Operation(summary = "닉네임과 친해지고픈 친구 필드를 이용해 멤버를 생성하는 API", description = "닉네임과 친해지고픈 친구 필드를 이용해 멤버를 생성합니다")
    public ResponseEntity<MemberCreateResponseDto> createMember(@RequestBody MemberCreateRequestDto requestDto) {
        return ResponseEntity.ok(memberService.create(requestDto));
    }

    @GetMapping("/main")
    @Operation(summary = "홈 화면에 GET API", description = "친해지고 싶은 친구 수 반환합니다.")
    public ResponseEntity<GetMainResponseDto> getMain(@RequestParam Long memberId) {
        return ResponseEntity.ok(memberService.findMain(memberId));
    }
}
