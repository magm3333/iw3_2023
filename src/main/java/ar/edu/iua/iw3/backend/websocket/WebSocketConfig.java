package ar.edu.iua.iw3.backend.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
    	//Crea un broker de mensajes en memoria, los suscriptores deben hacerlo con el prefijo /topic
    	// broker --> suscriptor
        config.enableSimpleBroker("/topic");
        
        //Agrega un prefijo a los mensajes recibidos desde los publicadores, a esto lo definiremos en el 
        //controlador con @MessageMapping("/algo"), por lo tanto el cliente que publique, deberá hacerlo en /ws/algo  
        // publicador ---> broker
        config.setApplicationDestinationPrefixes("/ws");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
    	//Se agrega un endpoint denominado /chat, además de agrega la caracterítica SockJS, lo que
    	//permite disponer de vías alternativas en el caso de que el navegador no soporte websoket
    	//o existan restricciones de proxy por ejemplo.
    	//El endpoint es el punto en común "físico" de la comunicaión
         registry.addEndpoint("/chat");
         registry.addEndpoint("/chat").withSockJS();
         
         registry.addEndpoint("/demo/graph");
         registry.addEndpoint("/demo/graph").withSockJS();
    }
}