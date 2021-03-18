package MicroEShop.MCommande.exception;

import MicroEShop.MCommande.util.CommandeNotFounException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorDto> handle(Throwable e){
        if(e.getMessage() != null){
            if(e instanceof CommandeNotFounException){
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(ErrorDto.builder()
                                .message(e.getMessage())
                                .timestamp(Instant.now())
                                .build());
            }
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorDto.builder()
                .message("Probleme back")
                .timestamp(Instant.now())
                .build());
    }
}
