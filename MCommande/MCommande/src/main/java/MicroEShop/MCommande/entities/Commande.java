package MicroEShop.MCommande.entities;

import MicroEShop.MLivraison.enums.SocieteLivraison;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    Integer productId;

    @CreationTimestamp
    Instant dateCommande;

    Integer quantiteCommande;

    Boolean commandeEstPaye;

    SocieteLivraison societeLivraison;

}
