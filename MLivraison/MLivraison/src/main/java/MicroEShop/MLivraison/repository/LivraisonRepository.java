package MicroEShop.MLivraison.repository;

import MicroEShop.MLivraison.entitie.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivraisonRepository extends JpaRepository<Livraison,Integer> {
    Livraison findByCommandeId(int id);
}
