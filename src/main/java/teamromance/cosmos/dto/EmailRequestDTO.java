package teamromance.cosmos.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EmailRequestDTO {
    private String userEmail;
    private String to;
    private String subject;
    private String text;
}
