package MicroEShop.MPaiement.mapper;

import MicroEShop.MPaiement.dto.PaiementDTO;
import MicroEShop.MPaiement.entities.Paiement;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public PaiementDTO toDto(Paiement entity){
        return entity != null ? PaiementDTO.builder()
                .id(entity.getId())
                .commandeId(entity.getCommandeId())
                .montant(entity.getMontant())
                .iban(entity.getIban())
                .build() : null;
    }

    public Paiement toEntity(PaiementDTO dto){

        return dto != null ? Paiement.builder()
                .id(dto.getId())
                .commandeId(dto.getCommandeId())
                .montant(dto.getMontant())
                .iban(dto.getIban())
                .build() : null;
    }

}
