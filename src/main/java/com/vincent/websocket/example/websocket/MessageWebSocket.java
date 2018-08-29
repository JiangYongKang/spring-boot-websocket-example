package com.vincent.websocket.example.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Author: vincent
 * Date: 2018-08-28 22:22:00
 * Comment:
 */

@Slf4j
@Component
@ServerEndpoint("/ws/message")
public class MessageWebSocket {

    public static CopyOnWriteArraySet<MessageWebSocket> messageWebSockets = new CopyOnWriteArraySet<>();

    private Session session;

    @OnOpen
    public void onOpenAction(Session session) throws IOException {
        log.info("建立连接，当前用户会话: " + session.getId());
        this.session = session;
        messageWebSockets.add(this);
    }

    @OnMessage
    public void onMessageAction(Session session, String message) {
        log.info("接受到消息：" + message);
    }

    @OnClose
    public void onCloseAction() {
        log.info("会话关闭，当前用户会话：" + this.session.getId());
        messageWebSockets.remove(this);
    }

    @OnError
    public void onErrorAction(Session session, Throwable throwable) {
        log.info("会话发生错误！当前会话：" + session.getId());
        throwable.printStackTrace();
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

}
