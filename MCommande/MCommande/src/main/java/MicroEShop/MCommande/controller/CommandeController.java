package MicroEShop.MCommande.controller;

import MicroEShop.MCommande.dto.CommandeDTO;
import MicroEShop.MCommande.entities.Commande;
import MicroEShop.MCommande.services.CommandeService;
import MicroEShop.MCommande.util.CommandeExpedie;
import MicroEShop.MCommande.util.CommandeId;
import MicroEShop.MCommande.util.CommandeNotFounException;
import MicroEShop.MLivraison.enums.SocieteLivraison;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/commandes")
@CrossOrigin
public class CommandeController {

    private final CommandeService service;


    public CommandeController(CommandeService service) {
        this.service = service;
    }

    @GetMapping
    public List<CommandeDTO> getAllCommande(){
        return service.getAllCommande();
    }

    @GetMapping(path = "/{id}")
    public CommandeDTO getOneCommande(@PathVariable int id) throws CommandeNotFounException {
        return  service.getOneCommande(id);
    }

    @PostMapping
    public ResponseEntity<CommandeDTO> insertCommande(@RequestBody Commande commande){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(commande));
    }

    //Requete plus utilise quand on utilise rabbitMQ
    @PostMapping(path = "/paid", consumes = "application/json")
    public void payeCommande(@RequestBody CommandeId commandeId) throws CommandeNotFounException {
        service.updatePaiementFlag(commandeId.getCommandeId());
    }

}
