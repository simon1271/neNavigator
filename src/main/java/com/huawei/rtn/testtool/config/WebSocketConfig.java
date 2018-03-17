package com.huawei.rtn.testtool.config;

import com.huawei.rtn.testtool.service.NeNavigatorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@EnableWebSocket
@Configuration
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(neNavigatorHandler(), "/nav").withSockJS();
    }

    @Bean
    public NeNavigatorService neNavigatorHandler() {
        return new NeNavigatorService();
    }
}
