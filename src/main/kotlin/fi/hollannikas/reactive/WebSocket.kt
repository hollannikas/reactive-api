package fi.hollannikas.reactive

import org.springframework.stereotype.Component
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.WebSocketSession
import reactor.core.publisher.Mono

@Component
class MessageSocketHandler(val repository: MessageRepository) : WebSocketHandler {

    override fun handle(session: WebSocketSession): Mono<Void> {
        return session.send(
                repository.findAll()
                        .map { it.text }
                        .map(session::textMessage)
        )
    }
}