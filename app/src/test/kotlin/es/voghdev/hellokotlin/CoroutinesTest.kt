package es.voghdev.hellokotlin

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch
import org.junit.Assert.assertEquals
import org.junit.Test

class CoroutinesTest {
    @Test
    fun `should execute some task in a coroutine then assert a calculated result`() {

        var x = 5f

        launch(CommonPool) {
            x = 6f
            assertEquals(6f, x)
        }

        assertEquals(5f, x) // This may not be thread-safe! But we're experimenting :-)
    }

    @Test
    fun `should execute a future and assert a calculated result`() {

    }

}
