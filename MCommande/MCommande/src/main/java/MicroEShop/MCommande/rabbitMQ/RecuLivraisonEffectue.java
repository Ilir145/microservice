package MicroEShop.MCommande.rabbitMQ;

import MicroEShop.MCommande.services.CommandeService;
import MicroEShop.MCommande.util.CommandeExpedie;
import MicroEShop.MCommande.util.CommandeNotFounException;
import MicroEShop.MLivraison.enums.SocieteLivraison;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@RabbitListener(queues = "queueLivraisonEffectue")
public class RecuLivraisonEffectue {

    @Autowired
    private CommandeService commandeService;

    @RabbitHandler
    public void recois(String in) throws CommandeNotFounException {
        System.out.println(in);
        Gson gson = new Gson();
        CommandeExpedie commandeExpedie = gson.fromJson(in,CommandeExpedie.class);
        commandeService.updateSocieteLivraison(commandeExpedie.getCommandeId(),commandeExpedie.getSocieteLivraison());
        System.out.println("[x] Receive [ Expedition effectuer pour  " + commandeExpedie.getCommandeId() + "]");

    }
}
