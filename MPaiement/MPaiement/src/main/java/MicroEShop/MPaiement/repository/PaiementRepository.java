package MicroEShop.MPaiement.repository;

import MicroEShop.MPaiement.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement,Integer> {

    Paiement findByCommandeId(int id);
}
