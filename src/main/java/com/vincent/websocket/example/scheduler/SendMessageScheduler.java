package com.vincent.websocket.example.scheduler;

import com.vincent.websocket.example.websocket.MessageWebSocket;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Author: vincent
 * Date: 2018-08-28 22:41:00
 * Comment:
 */

@Component
public class SendMessageScheduler {

    @Scheduled(fixedDelay = 1000)
    public void sendMessage() throws IOException {
        for (MessageWebSocket messageWebSocket : MessageWebSocket.messageWebSockets) {
            messageWebSocket.sendMessage("当前时间：" + System.currentTimeMillis());
        }
    }
}
