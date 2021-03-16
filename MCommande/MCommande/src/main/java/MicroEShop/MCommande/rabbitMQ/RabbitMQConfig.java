package MicroEShop.MCommande.rabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue paymentDoneQueue(){
        return new Queue("paymentDoneQueue");
    }

    @Bean
    public Queue queueLivraisonEffectue() { return  new Queue("queueLivraisonEffectue");}

    @Bean
    public PaymentDoneReceiver paymentDoneReceiver(){
        return new PaymentDoneReceiver();
    }

    @Bean
    public RecuLivraisonEffectue recuLivraisonEffectue(){return new RecuLivraisonEffectue();}
}
