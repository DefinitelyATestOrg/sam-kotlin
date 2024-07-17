// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.entities

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class IndustryCodeServiceTest {

    @Test
    fun callCreate() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val industryCodeService = client.entities().industryCode()
        val entity =
            industryCodeService.create(
                EntityIndustryCodeCreateParams.builder()
                    .entityId("entity_id")
                    .industryCode("x")
                    .build()
            )
        println(entity)
        entity.validate()
    }
}
