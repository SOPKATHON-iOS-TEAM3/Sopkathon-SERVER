package sopkathon.mobile3.answer.service.dto;

import java.util.List;

public record AnswerCreateRequest(
        Long questionId,
        List<AnswerDto> answers
) {
}