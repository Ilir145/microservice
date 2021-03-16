package MicroEShop.MLivraison.rabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue queueLivraisonEffectue() {
        return  new Queue("queueLivraisonEffectue");
    }

    @Bean
    public EnvoisLivraisonEffectue envoisLivraisonEffectue(){
        return  new EnvoisLivraisonEffectue();
    };
}
