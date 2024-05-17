package sopkathon.mobile3.exception;

import lombok.Getter;
import sopkathon.mobile3.common.dto.message.ErrorMessage;

@Getter
public class BusinessException extends RuntimeException {

    private ErrorMessage errorMessage;

    public BusinessException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}