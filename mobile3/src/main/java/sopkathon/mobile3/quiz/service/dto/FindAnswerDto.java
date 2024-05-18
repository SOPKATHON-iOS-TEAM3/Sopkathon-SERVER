package sopkathon.mobile3.quiz.service.dto;

import sopkathon.mobile3.answer.domain.Answer;

public record FindAnswerDto(Long answerId, Long questionId, String answerText) {
    public static FindAnswerDto of(Answer answer) {
        return new FindAnswerDto(answer.getAnswerId(), answer.getQuestion().getQuestionId(), answer.getAnswerText());
    }
}
