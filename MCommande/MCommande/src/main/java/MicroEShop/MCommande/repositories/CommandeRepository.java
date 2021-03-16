package MicroEShop.MCommande.repositories;

import MicroEShop.MCommande.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Integer> {
}
