package fi.hollannikas.reactive

import java.time.LocalDateTime
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.findAll
import org.springframework.data.mongodb.core.findById
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import java.time.LocalDateTime.now


@Repository
class MessageRepository(private val template: ReactiveMongoTemplate) {
    fun save(message: Mono<Message>) = template.save(message)
    fun findOne(id: String) = template.findById<Message>(id)
    fun findAll() = template.findAll<Message>()
}

@Document
data class Message(
        @Id val id: String? = null,
        @Field val text: String,
        @CreatedDate val createdDate: LocalDateTime = now()
)