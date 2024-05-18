package sopkathon.mobile3.question.service.dto;

public record QuestionCreateRequest(
        Long quizId,
        String questionText
) {
}
