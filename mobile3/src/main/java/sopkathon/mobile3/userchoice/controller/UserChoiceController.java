package sopkathon.mobile3.userchoice.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopkathon.mobile3.common.dto.SuccessStatusResponse;
import sopkathon.mobile3.member.service.dto.UserChoiceCreateRequestDto;
import sopkathon.mobile3.userchoice.service.UserChoiceService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserChoiceController {

    private final UserChoiceService userChoiceService;

    @PostMapping("/user-choice")
    @Operation(summary = "답변 선택에 대한 정답 여부를 저장하고 마지막 질문에 대한 답변 시 총 친해지고 싶은 사람을 한명 감소하는  API", description = "memberId, questionId, answerId와 정답 여부를 저장합니다.")
    public ResponseEntity<SuccessStatusResponse> createUserChoice(@RequestBody UserChoiceCreateRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userChoiceService.createUserChoice(requestDto));
    }
}
