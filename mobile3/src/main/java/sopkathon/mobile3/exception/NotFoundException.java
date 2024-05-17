package sopkathon.mobile3.exception;

import sopkathon.mobile3.common.dto.message.ErrorMessage;

public class NotFoundException extends BusinessException {
    public NotFoundException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
