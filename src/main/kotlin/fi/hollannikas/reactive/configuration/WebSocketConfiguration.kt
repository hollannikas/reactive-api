package fi.hollannikas.reactive.configuration

import fi.hollannikas.reactive.MessageRepository
import fi.hollannikas.reactive.MessageSocketHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.HandlerMapping
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter



@Configuration
class WebSocketConfiguration(val repository: MessageRepository) {

    @Bean
    fun webSocketHandlerMapping(): HandlerMapping {
        val handlerMapping = SimpleUrlHandlerMapping()
        handlerMapping.urlMap = mapOf(
                "/ws/messages" to MessageSocketHandler(repository)
        )
        handlerMapping.order = 1
        return handlerMapping
    }

    @Bean
    fun handlerAdapter(): WebSocketHandlerAdapter {
        return WebSocketHandlerAdapter()
    }
}
