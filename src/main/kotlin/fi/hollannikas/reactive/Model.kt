package fi.hollannikas.reactive

import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import java.time.LocalDateTime
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field


internal interface MessageRepository : ReactiveMongoRepository<MessageDocument, String>

@Document
internal class MessageDocument(
        @Id val id: ObjectId,
        @Field val text: String,
        @CreatedDate val createdDate: LocalDateTime
)