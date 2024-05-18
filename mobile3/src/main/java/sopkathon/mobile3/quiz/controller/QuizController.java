package sopkathon.mobile3.quiz.controller;

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
import sopkathon.mobile3.quiz.service.QuizService;
import sopkathon.mobile3.quiz.service.dto.QuizCreateRequest;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping("/quiz")
    @Operation(summary = "멤버 아이디로 퀴즈를 생성하는 API", description = "멤버 아이디를 RequestBody로 받아 퀴즈를 생성합니다.")
    public ResponseEntity<SuccessStatusResponse> createQuiz(@RequestBody QuizCreateRequest quizCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", quizService.createQuiz(quizCreateRequest.memberId()))
                .body(SuccessStatusResponse.of(SuccessMessage.QUIZ_CREATE_SUCCESS));
    }
}
