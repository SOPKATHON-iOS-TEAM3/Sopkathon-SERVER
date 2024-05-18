package sopkathon.mobile3.answer.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopkathon.mobile3.answer.service.AnswerService;
import sopkathon.mobile3.answer.service.dto.AnswerCreateRequest;
import sopkathon.mobile3.common.dto.SuccessStatusResponse;
import sopkathon.mobile3.common.dto.message.SuccessMessage;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @Operation(summary = "답변 생성 및 난수 생성", description = "주어진 질문에 대한 두 개의 답변을 생성하고 총 3개의 질문과 그에 따른 6개의 답변 생성 시 난수를 반환합니다. ")
    @PostMapping("/answers")
    public ResponseEntity<SuccessStatusResponse> createAnswers(@RequestBody AnswerCreateRequest answerCreateRequest) {
        String inviteCode = answerService.createAnswers(answerCreateRequest);
        if (inviteCode != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(SuccessStatusResponse.of("모든 질문 완료, 초대코드: " + inviteCode));
        } else {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(SuccessStatusResponse.of(SuccessMessage.ANSWER_CREATE_SUCCESS));
        }
    }
}