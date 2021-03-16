package MicroEShop.MLivraison.mapper;

import MicroEShop.MLivraison.dto.LivraisonDTO;
import MicroEShop.MLivraison.entitie.Livraison;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public LivraisonDTO toDTO(Livraison entity){
        return entity != null ? LivraisonDTO.builder()
                .id(entity.getId())
                .dateCreation(entity.getDateCreation())
                .dateLivraison(entity.getDateLivraison())
                .prix(entity.getPrix())
                .societeLivraison(entity.getSocieteLivraison())
                .commandeId(entity.getCommandeId())
                .build(): null;
    }

    public Livraison toEntity(LivraisonDTO dto){
        return dto != null ? Livraison.builder()
                .id(dto.getId())
                .dateCreation(dto.getDateCreation())
                .dateLivraison(dto.getDateLivraison())
                .prix(dto.getPrix())
                .societeLivraison(dto.getSocieteLivraison())
                .commandeId(dto.getCommandeId())
                .build(): null;
    }
}
