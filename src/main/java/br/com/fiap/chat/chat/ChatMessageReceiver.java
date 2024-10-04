package br.com.fiap.chat.chat;

import lombok.Getter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import br.com.fiap.chat.config.RabbitMQConfig;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class ChatMessageReceiver {
    private final List<String> messages = new ArrayList<>();

    @RabbitListener(queues = RabbitMQConfig.CHAT_QUEUE)
    public void receiveMessage(String message) {
        messages.add(message);
    }
}
