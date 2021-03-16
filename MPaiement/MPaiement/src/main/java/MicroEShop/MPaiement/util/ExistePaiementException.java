package MicroEShop.MPaiement.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExistePaiementException extends Exception {
    public ExistePaiementException(String message) {
        super(message);
    }
}
