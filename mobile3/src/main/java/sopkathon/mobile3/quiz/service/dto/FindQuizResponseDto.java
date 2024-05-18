package sopkathon.mobile3.quiz.service.dto;

import java.util.List;

public record FindQuizResponseDto(
        List<FindQuestionDto> questions,
        List<FindAnswerDto> answers
) {
}
