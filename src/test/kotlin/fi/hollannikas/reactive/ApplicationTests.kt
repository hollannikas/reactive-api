package fi.hollannikas.reactive

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
class ApplicationTests {

    @Test
    fun contextLoads() {
        assertEquals(1, 1)
    }

}