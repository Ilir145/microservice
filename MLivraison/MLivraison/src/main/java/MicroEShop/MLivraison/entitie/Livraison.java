package MicroEShop.MLivraison.entitie;

import MicroEShop.MLivraison.enums.SocieteLivraison;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.logging.log4j.CloseableThreadContext;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Livraison {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @CreationTimestamp
    Instant dateCreation;

    Instant dateLivraison;

    SocieteLivraison societeLivraison;

    Integer prix;

    @Column(unique = true)
    Integer commandeId;

}
