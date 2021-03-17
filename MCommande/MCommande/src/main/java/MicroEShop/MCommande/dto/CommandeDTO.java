package MicroEShop.MCommande.dto;

import MicroEShop.MLivraison.enums.SocieteLivraison;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class CommandeDTO {

    Integer id;

    Integer productId;

    Instant dateCommande;

    Integer quantiteCommande;

    Boolean commandeEstPaye;

    String societeLivraison;

}
