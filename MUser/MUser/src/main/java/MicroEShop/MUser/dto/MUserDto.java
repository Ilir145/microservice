package MicroEShop.MUser.dto;

import MicroEShop.MUser.entity.Adresse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embedded;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class MUserDto {

    int id;

    String pseudo;

    String mdp;

    String nom;

    String prenom;

    String email;

    Adresse adresse_facturation;

    Adresse adresse_livraison;
}
