package MicroEShop.MProduit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorDto> handle(){

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorDto.builder()
                .message("Probleme back")
                .timestamp(Instant.now())
                .build());
    }
}
