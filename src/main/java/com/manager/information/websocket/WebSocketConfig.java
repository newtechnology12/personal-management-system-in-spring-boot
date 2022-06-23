//package com.manager.information.websocket;
//
//
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//@EnableWebSocketMessageBroker
//public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry config) {
//        config.enableSimpleBroker("/topic/", "/queue/");
//        config.setApplicationDestinationPrefixes("/app");
//    }
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/greeting");;
//    }
//
//}