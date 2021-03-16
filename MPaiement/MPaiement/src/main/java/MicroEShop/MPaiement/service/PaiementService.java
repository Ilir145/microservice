package MicroEShop.MPaiement.service;

import MicroEShop.MPaiement.dto.PaiementDTO;
import MicroEShop.MPaiement.entities.Paiement;
import MicroEShop.MPaiement.mapper.Mapper;
import MicroEShop.MPaiement.rabbitMQ.PaymentDoneSender;
import MicroEShop.MPaiement.repository.PaiementRepository;
import MicroEShop.MPaiement.util.ExistePaiementException;
import MicroEShop.MPaiement.util.PaiementImpossibleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaiementService {

    private final PaiementRepository repository;

    @Autowired
    private PaymentDoneSender paymentDoneSender;

    private final HttpCommandeService httpCommandeService;

    private final Mapper mapper;

    public PaiementService(PaiementRepository repository, HttpCommandeService httpCommandeService, Mapper mapper) {
        this.repository = repository;
        this.httpCommandeService = httpCommandeService;
        this.mapper = mapper;
    }

    public PaiementDTO payeCommande(Paiement paiement) throws Exception {

        //Verif que commande pas deja paye
        Paiement paiementExistant = this.repository.findByCommandeId(paiement.getCommandeId());
        if(paiementExistant != null) throw new ExistePaiementException("La commande a deja ete paye");

        //Enregistrer le paiement
        Paiement newPaiement = this.repository.save(paiement);

        if(newPaiement == null) throw new PaiementImpossibleException("Le paiement est impossible");

        //via un appelle d API
        //httpCommandeService.paidOrderRequest(newPaiement.getCommandeId());

        //RabbitMQ
        paymentDoneSender.send(newPaiement.getCommandeId());

        //Appeler le microservice mCommande pour communiquer que le paiement est effectue
        return mapper.toDto(newPaiement);
    }
}
