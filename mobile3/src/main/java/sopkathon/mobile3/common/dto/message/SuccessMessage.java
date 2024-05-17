package sopkathon.mobile3.common.dto.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessMessage {

    private final int status;
    private final String message;
}
