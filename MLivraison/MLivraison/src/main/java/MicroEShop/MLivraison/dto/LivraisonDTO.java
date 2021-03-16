package MicroEShop.MLivraison.dto;

import MicroEShop.MLivraison.enums.SocieteLivraison;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class LivraisonDTO {

    Integer id;

    Instant dateCreation;

    Instant dateLivraison;

    SocieteLivraison societeLivraison;

    Integer prix;

    Integer commandeId;
}
