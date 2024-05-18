package sopkathon.mobile3.common.dto;

import sopkathon.mobile3.common.dto.message.SuccessMessage;

public record SuccessStatusResponse(
        int status,
        String message
) {

    public static SuccessStatusResponse of(SuccessMessage successMessage) {
        return new SuccessStatusResponse(successMessage.getStatus(), successMessage.getMessage());
    }

    public static SuccessStatusResponse of(String customMessage) {
        return new SuccessStatusResponse(201, customMessage);
    }

}
