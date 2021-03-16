package MicroEShop.MCommande.rabbitMQ;

import MicroEShop.MCommande.services.CommandeService;
import MicroEShop.MCommande.util.CommandeId;
import MicroEShop.MCommande.util.CommandeNotFounException;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@RabbitListener(queues = "paymentDoneQueue")
public class PaymentDoneReceiver {

    @Autowired
    private CommandeService commandeService;

    @RabbitHandler
    public void receive(String in) throws CommandeNotFounException {
        Gson gson = new Gson();
        CommandeId commandeId = gson.fromJson(in,CommandeId.class);
        commandeService.updatePaiementFlag(commandeId.getCommandeId());
        System.out.println("[x] Receive [ Paiement effectuer pour  " + commandeId.getCommandeId() + "]");

    }
}
