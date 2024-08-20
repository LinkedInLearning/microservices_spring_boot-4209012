package bbq.order.config;


import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.support.converter.Jackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class RabbitMqConfiguration {

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        var messageConverter = new Jackson2JsonMessageConverter();
        messageConverter.setTypePrecedence(Jackson2JavaTypeMapper.TypePrecedence.INFERRED);
        return messageConverter;
    }

    @Bean
    public Declarables rabbitDeclarables() {
        // Publish/Subscribe
        var kitchenOrdersQueue = QueueBuilder.nonDurable("kitchen.orders").build();
        var deliveryOrdersQueue = QueueBuilder.nonDurable("delivery.orders").build();
        var ordersExchange = new FanoutExchange("orders");
        var kitchenOrdersBinding = BindingBuilder.bind(kitchenOrdersQueue).to(ordersExchange);
        var deliveryOrdersBinding = BindingBuilder.bind(deliveryOrdersQueue).to(ordersExchange);

        return new Declarables(
                kitchenOrdersQueue,
                deliveryOrdersQueue,
                ordersExchange,
                kitchenOrdersBinding,
                deliveryOrdersBinding
        );
    }
}
