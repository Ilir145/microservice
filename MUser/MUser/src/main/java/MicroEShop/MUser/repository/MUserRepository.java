package MicroEShop.MUser.repository;

import MicroEShop.MUser.entity.MUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MUserRepository extends JpaRepository<MUser,Integer> {

    Optional<MUser> findByPseudoAndMdp(String pseudo,String mdp);

}
