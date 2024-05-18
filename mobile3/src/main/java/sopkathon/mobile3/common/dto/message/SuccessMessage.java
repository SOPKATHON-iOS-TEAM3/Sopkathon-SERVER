package sopkathon.mobile3.common.dto.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessMessage {


    MEMBER_CREATE_SUCCESS(HttpStatus.CREATED.value(),"멤버 생성 완료"),
    ANSWER_CREATE_SUCCESS(HttpStatus.CREATED.value(),"답변 생성 완료");
    private final int status;
    private final String message;
}
