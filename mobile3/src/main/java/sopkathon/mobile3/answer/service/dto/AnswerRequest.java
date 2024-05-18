package sopkathon.mobile3.answer.service.dto;

import sopkathon.mobile3.answer.domain.Answer;

import java.util.List;

public record AnswerRequest(
        Long quizId,
        List<Answer> answers
) {
}
