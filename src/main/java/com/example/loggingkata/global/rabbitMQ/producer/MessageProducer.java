package com.example.loggingkata.global.rabbitMQ.producer;

import com.example.loggingkata.global.rabbitMQ.dto.LogEventMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MessageProducer {

    @Value("${spring.rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${spring.rabbitmq.routing.key}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    /**
     * Queue로 메시지를 발행
     *
     * @param payload 발행할 메시지의 DTO 객체
     */
    public void sendMessage(Object payload) {
        LogEventMessage logEventMessage = new LogEventMessage(payload);
        log.info("message sent: {}", logEventMessage.getPayload().toString());
        rabbitTemplate.convertAndSend(exchangeName, routingKey, logEventMessage);
    }
}
