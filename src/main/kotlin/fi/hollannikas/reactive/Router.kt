package fi.hollannikas.reactive

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.router

@Configuration
class ApplicationRoutes(val messageHandler: MessageHandler) {

    @Bean
    fun routes() = router {
        (accept(APPLICATION_JSON) and "/api").nest {
            "/message".nest {
                POST("/", messageHandler::createMessage)
                GET("/", messageHandler::findAll)
                GET("/{id}", messageHandler::findOne)
            }
        }
    }
}