package sopkathon.mobile3.question.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopkathon.mobile3.common.dto.SuccessStatusResponse;
import sopkathon.mobile3.common.dto.message.SuccessMessage;
import sopkathon.mobile3.question.service.QuestionService;
import sopkathon.mobile3.question.service.dto.QuestionCreateRequest;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @Operation(summary = "질문 생성", description = "주어진 퀴즈에 대한 새로운 질문을 생성합니다.")
    @PostMapping("/question")
    public ResponseEntity<SuccessStatusResponse> createQuestion(@RequestBody QuestionCreateRequest questionCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location",questionService.createQuestion(questionCreateRequest))
                .body(SuccessStatusResponse.of(SuccessMessage.QUESTION_CREATE_SUCCESS));
    }
}