package MicroEShop.MCommande.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CommandeNotFounException extends Exception {

    public CommandeNotFounException(String message) {
        super(message);
    }
}
