package MicroEShop.MCommande.mapper;

import MicroEShop.MCommande.dto.CommandeDTO;
import MicroEShop.MCommande.entities.Commande;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public CommandeDTO toDTO(Commande entity){
        return entity != null ? CommandeDTO.builder()
                .id(entity.getId())
                .dateCommande(entity.getDateCommande())
                .commandeEstPaye(entity.getCommandeEstPaye())
                .quantiteCommande(entity.getQuantiteCommande())
                .productId(entity.getProductId())
                .societeLivraison(entity.getSocieteLivraison())
                .build() : null;
    }

    public Commande toEntity(CommandeDTO dto){
        return dto != null ? Commande.builder()
                .id(dto.getId())
                .dateCommande(dto.getDateCommande())
                .commandeEstPaye(dto.getCommandeEstPaye())
                .quantiteCommande(dto.getQuantiteCommande())
                .productId(dto.getProductId())
                .societeLivraison(dto.getSocieteLivraison())
                .build() : null;
    }
}
