package MicroEShop.MCommande.util;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommandeId implements Serializable {
    int  commandeId;
}
