package MicroEShop.MCommande.util;

import MicroEShop.MLivraison.enums.SocieteLivraison;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommandeExpedie implements Serializable {

    int  commandeId;
    SocieteLivraison societeLivraison;
}
