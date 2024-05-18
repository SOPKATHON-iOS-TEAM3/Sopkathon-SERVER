package sopkathon.mobile3.quiz.service.dto;

import sopkathon.mobile3.question.domain.Question;

public record FindQuestionDto(Long questionId, String questionText) {
    public static FindQuestionDto of(Question question) {
        return new FindQuestionDto(question.getQuestionId(), question.getQuestionText());
    }
}
