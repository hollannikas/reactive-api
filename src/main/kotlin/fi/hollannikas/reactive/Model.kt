package fi.hollannikas.reactive

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.data.mongodb.repository.Tailable
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import java.time.LocalDateTime
import java.time.LocalDateTime.now


interface MessageRepository : ReactiveCrudRepository<Message, String> {
    @Tailable
    fun findWithTailableCursorBy(): Flux<Message>
}

@Document(collection = "messages")
data class Message(
        @Id val id: String? = null,
        @Field val text: String,
        @CreatedDate val createdDate: LocalDateTime = now()
)