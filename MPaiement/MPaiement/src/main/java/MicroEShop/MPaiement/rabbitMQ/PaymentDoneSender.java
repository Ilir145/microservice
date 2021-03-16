package MicroEShop.MPaiement.rabbitMQ;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashMap;

public class PaymentDoneSender {

    @Autowired
    public RabbitTemplate template;

    @Autowired
    @Qualifier(value = "paymentDoneQueue")
    private Queue queue;

    public  void send(int commandeId) throws JsonProcessingException {
        var values = new HashMap<String,Integer>() {{
            put("commandeId",commandeId);
        }};

        this.template.convertAndSend(queue.getName(), new ObjectMapper().writeValueAsString(values));
        System.out.println("[x] Sent [Paiement effectue pour la commande " + commandeId + " ]");;
    }
}
