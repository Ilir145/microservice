package MicroEShop.MUser.entity;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;


@Embeddable
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Adresse {

    String rue;

    String numero;

    String localite;

    Integer codePostal;


}
