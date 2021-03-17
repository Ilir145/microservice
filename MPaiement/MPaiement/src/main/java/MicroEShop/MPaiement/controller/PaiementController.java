package MicroEShop.MPaiement.controller;

import MicroEShop.MPaiement.dto.PaiementDTO;
import MicroEShop.MPaiement.entities.Paiement;
import MicroEShop.MPaiement.service.PaiementService;
import MicroEShop.MPaiement.util.ExistePaiementException;
import MicroEShop.MPaiement.util.PaiementImpossibleException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/paiements")
//@CrossOrigin
public class PaiementController {

    private final PaiementService service;


    public PaiementController(PaiementService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PaiementDTO> payeCommande(@RequestBody Paiement paiement) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.payeCommande(paiement));
    }
}
