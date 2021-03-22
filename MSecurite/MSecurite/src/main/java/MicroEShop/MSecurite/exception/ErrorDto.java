package MicroEShop.MSecurite.exception;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDto {

    String message;

    Instant timestamp = Instant.now();
}
