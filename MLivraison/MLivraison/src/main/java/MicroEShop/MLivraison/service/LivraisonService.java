package MicroEShop.MLivraison.service;

import MicroEShop.MLivraison.dto.LivraisonDTO;
import MicroEShop.MLivraison.entitie.Livraison;
import MicroEShop.MLivraison.mapper.Mapper;
import MicroEShop.MLivraison.rabbitMQ.EnvoisLivraisonEffectue;
import MicroEShop.MLivraison.repository.LivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LivraisonService {

    private final  LivraisonRepository livraisonRepository;

    private final Mapper mapper;

    @Autowired
    private EnvoisLivraisonEffectue envoisLivraisonEffectue;


    public LivraisonService(LivraisonRepository livraisonRepository, Mapper mapper) {
        this.livraisonRepository = livraisonRepository;
        this.mapper = mapper;
    }

    public List<LivraisonDTO> getAllLivraison(){
        return this.livraisonRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }


    public LivraisonDTO getOneLivraison(int id) {
        Optional<Livraison> commande = livraisonRepository.findById(id);

        return commande.map(mapper::toDTO).orElse(null);
    }

    public LivraisonDTO insert(Livraison livraison){
        if(livraison != null){
            livraison = livraisonRepository.save(livraison);
            return mapper.toDTO(livraison);
        }

        return null;
    }

    public LivraisonDTO expedieCommande(Livraison livraison) throws Exception {

        Livraison livraisonExistante = this.livraisonRepository.findByCommandeId(livraison.getCommandeId());
        if(livraisonExistante != null) throw new Exception("La commande a deja ete paye");

        Livraison nouvelleLivraison = this.livraisonRepository.save(livraison);

        if(nouvelleLivraison == null) throw new Exception("Le paiement est impossible");


        envoisLivraisonEffectue.envoyer(nouvelleLivraison.getCommandeId());

        return mapper.toDTO(nouvelleLivraison);
    }
}
