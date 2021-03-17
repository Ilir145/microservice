package MicroEShop.MLivraison.controller;

import MicroEShop.MLivraison.dto.LivraisonDTO;
import MicroEShop.MLivraison.entitie.Livraison;
import MicroEShop.MLivraison.service.LivraisonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/livraisons")
//@CrossOrigin
public class LivraisonController {

    private  final LivraisonService livraisonService;


    public LivraisonController(LivraisonService livraisonService) {
        this.livraisonService = livraisonService;
    }

    @GetMapping
    public List<LivraisonDTO> getAllLivraison(){
        return livraisonService.getAllLivraison();
    }

    @GetMapping(path = "/{id}")
    public LivraisonDTO getOneLivraison(@PathVariable int id){
        return livraisonService.getOneLivraison(id);
    }

    @PostMapping
    public void insertLivraison(@RequestBody Livraison livraison) throws Exception {
        this.livraisonService.expedieCommande(livraison);
    }


}
