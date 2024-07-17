// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.entities

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*
import software.elborai.api.models.EntitySupplementalDocumentListParams

@ExtendWith(TestServerExtension::class)
class SupplementalDocumentServiceTest {

    @Test
    fun callCreate() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val supplementalDocumentService = client.entities().supplementalDocuments()
        val entity =
            supplementalDocumentService.create(
                EntitySupplementalDocumentCreateParams.builder()
                    .entityId("string")
                    .fileId("string")
                    .build()
            )
        println(entity)
        entity.validate()
    }

    @Test
    fun callList() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val supplementalDocumentService = client.entities().supplementalDocuments()
        val supplementalDocumentList =
            supplementalDocumentService.list(
                EntitySupplementalDocumentListParams.builder().entityId("string").build()
            )
        println(supplementalDocumentList)
        supplementalDocumentList.data().forEach { it.validate() }
    }
}
