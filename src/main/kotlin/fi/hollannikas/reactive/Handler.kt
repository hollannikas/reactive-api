package fi.hollannikas.reactive

import org.springframework.http.MediaType.APPLICATION_JSON_UTF8
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.created
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.toMono
import java.net.URI.create

fun ServerResponse.BodyBuilder.json() = contentType(APPLICATION_JSON_UTF8)

@Service
class MessageHandler(val repository: MessageRepository) {
    fun createMessage(request: ServerRequest) =
            request.bodyToMono<Message>()
                    .flatMap { repository.save(it) }
                    .flatMap { created(create("/api/message/${it.id}"))
                            .json()
                            .body(it.toMono()) }

    fun findOne(request: ServerRequest) =
            ok()
                    .json()
                    .body(repository.findById(request.pathVariable("id")))

    fun findAll(request: ServerRequest) =
            ok()
                    .json()
                    .body(repository.findAll())
}