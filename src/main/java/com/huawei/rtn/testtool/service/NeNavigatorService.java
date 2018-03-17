package com.huawei.rtn.testtool.service;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

public class NeNavigatorService extends AbstractWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
        throws Exception {
        String content = message.getPayload();
        Thread.sleep(2000);
        session.sendMessage(new TextMessage("reply: " + content));
    }
}
