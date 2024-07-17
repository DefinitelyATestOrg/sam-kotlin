// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*
import software.elborai.api.models.DocumentListParams

@ExtendWith(TestServerExtension::class)
class DocumentServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val documentService = client.documents()
        val document =
            documentService.retrieve(
                DocumentRetrieveParams.builder().documentId("document_id").build()
            )
        println(document)
        document.validate()
    }

    @Test
    fun callList() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val documentService = client.documents()
        val documentList = documentService.list(DocumentListParams.builder().build())
        println(documentList)
        documentList.data().forEach { it.validate() }
    }
}
