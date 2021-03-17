package MicroEShop.MCommande.services;

import MicroEShop.MCommande.dto.CommandeDTO;
import MicroEShop.MCommande.entities.Commande;
import MicroEShop.MCommande.mapper.Mapper;
import MicroEShop.MCommande.repositories.CommandeRepository;
import MicroEShop.MCommande.util.CommandeNotFounException;
import MicroEShop.MLivraison.enums.SocieteLivraison;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommandeService {

    private final CommandeRepository repository;

    private final Mapper mapper;


    public CommandeService(CommandeRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CommandeDTO> getAllCommande(){
        return this.repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public CommandeDTO getOneCommande(int id) throws CommandeNotFounException {
        Optional<Commande> commande = repository.findById(id);

        if(commande.isEmpty()) throw new CommandeNotFounException("La commande + " + id+ " n'a pas ete trouve");
        return commande.map(mapper::toDTO).orElse(null);
    }

    public CommandeDTO insert(Commande commande){
        if(commande != null){
            commande = repository.save(commande);
            return mapper.toDTO(commande);
        }

        return null;
    }

    public void updatePaiementFlag(int id) throws CommandeNotFounException {
        Optional<Commande> commande = repository.findById(id);

        if(commande.isEmpty()) throw new CommandeNotFounException("La commande + " + id+ " n'a pas ete trouve");

        commande.get().setCommandeEstPaye(true);
        repository.save(commande.get());
    }

    public void updateSocieteLivraison(int commandeId, String societeLivraison) throws CommandeNotFounException {
        Optional<Commande> commande = repository.findById(commandeId);

        if(commande.isEmpty()) throw new CommandeNotFounException("La commande + " + commandeId+ " n'a pas ete trouve");
        commande.get().setSocieteLivraison(societeLivraison);
        repository.save(commande.get());
    }
}
