package sopkathon.mobile3.common.dto.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorMessage {

    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "존재하지 않은 멤버 아이디입니다."),
    QUIZ_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "존재하지 않은 퀴즈 아이디입니다."),
    QUESTION_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "존재하지 않은 질문 아이디입니다."),
    ANSWER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "존재하지 않은 답변 아이디입니다.");
    private final int status;
    private final String message;
}
