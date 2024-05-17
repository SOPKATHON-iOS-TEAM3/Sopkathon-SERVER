package sopkathon.mobile3.common.dto.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorMessage {

    private final int status;
    private final String message;
}
