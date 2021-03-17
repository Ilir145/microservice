package MicroEShop.MUser.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.OverridesAttribute;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String pseudo;

    String mdp;

    String nom;

    String prenom;

    String email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="rue",column=@Column(name="ruef")),
            @AttributeOverride(name="numero",column=@Column(name="numerof")),
            @AttributeOverride(name="localite",column=@Column(name="localitef")),
            @AttributeOverride(name="codePostal",column=@Column(name="codePostalf"))
            })
    Adresse adresse_facturation;


    @Embedded
    Adresse adresse_livraison;

}
