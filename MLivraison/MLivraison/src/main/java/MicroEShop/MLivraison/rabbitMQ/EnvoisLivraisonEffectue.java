package MicroEShop.MLivraison.rabbitMQ;

import MicroEShop.MLivraison.enums.SocieteLivraison;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashMap;
import java.util.List;

public class EnvoisLivraisonEffectue {

    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Autowired
    @Qualifier(value = "queueLivraisonEffectue")
    private Queue queue;

    public  void envoyer(int commandeId, SocieteLivraison societeLivraison) throws JsonProcessingException {
        var values = new HashMap<String,Object>() {{
            put("commandeId",commandeId);
            put("societeLivraison",societeLivraison);
        }};

        this.rabbitTemplate.convertAndSend(queue.getName(), new ObjectMapper().writeValueAsString(values));
        System.out.println("[x] Sent [Expedition effectue pour la commande " + commandeId + " ]");;
    }
}
