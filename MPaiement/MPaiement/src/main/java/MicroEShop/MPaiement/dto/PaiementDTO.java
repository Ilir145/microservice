package MicroEShop.MPaiement.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class PaiementDTO {

    Integer id;

    Integer commandeId;

    Double montant;

    String iban;
}
