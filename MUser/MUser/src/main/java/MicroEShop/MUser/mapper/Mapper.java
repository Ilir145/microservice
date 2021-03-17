package MicroEShop.MUser.mapper;

import MicroEShop.MUser.dto.MUserDto;
import MicroEShop.MUser.entity.MUser;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public MUserDto toDto(MUser user){
        return user != null ? MUserDto.builder()
                .id(user.getId())
                .pseudo(user.getPseudo())
                .email(user.getEmail())
                .mdp(user.getMdp())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .adresse_facturation(user.getAdresse_facturation())
                .adresse_livraison(user.getAdresse_livraison())
                .build() : null;
    }

    public MUser toEntity(MUserDto dto ){
        return dto != null ? MUser.builder()
                .id(dto.getId())
                .pseudo(dto.getPseudo())
                .email(dto.getEmail())
                .mdp(dto.getMdp())
                .nom(dto.getNom())
                .prenom(dto.getPrenom())
                .adresse_facturation(dto.getAdresse_facturation())
                .adresse_livraison(dto.getAdresse_livraison())
                .build() : null;
    }
}
