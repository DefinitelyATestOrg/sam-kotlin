package me.elborai.api.core.handlers

import java.io.IOException
import java.io.InputStream
import kotlin.test.Test
import me.elborai.api.core.http.Headers
import me.elborai.api.core.http.HttpResponse
import me.elborai.api.errors.SamIoException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

internal class StreamHandlerTest {

    @Test
    fun streamHandler_whenReaderThrowsIOException_wrapsException() {
        val handler = streamHandler<String> { _, lines -> lines.forEach {} }
        val streamResponse = handler.handle(httpResponse("a\nb\nc\n".byteInputStream().throwing()))

        val e = assertThrows<SamIoException> { streamResponse.asSequence().forEach {} }
        assertThat(e).hasMessage("Stream failed")
        assertThat(e).hasCauseInstanceOf(IOException::class.java)
    }

    @Test
    fun streamHandler_whenBlockThrowsIOException_doesNotWrapException() {
        val ioException = IOException("BOOM!")
        val handler =
            streamHandler<String> { _, lines ->
                lines.forEachIndexed { index, _ ->
                    if (index == 2) {
                        throw ioException
                    }
                }
            }
        val streamResponse = handler.handle(httpResponse("a\nb\nc\n".byteInputStream()))

        val e = assertThrows<IOException> { streamResponse.asSequence().forEach {} }
        assertThat(e).isSameAs(ioException)
    }

    private fun httpResponse(body: InputStream): HttpResponse =
        object : HttpResponse {

            override fun statusCode(): Int = 0

            override fun headers(): Headers = Headers.builder().build()

            override fun body(): InputStream = body

            override fun close() {}
        }

    private fun InputStream.throwing(): InputStream =
        object : InputStream() {

            override fun read(): Int {
                val byte = this@throwing.read()
                if (byte == -1) {
                    throw IOException("BOOM!")
                }
                return byte
            }
        }
}
