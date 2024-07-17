// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*
import software.elborai.api.models.RoutingNumberListParams

@ExtendWith(TestServerExtension::class)
class RoutingNumberServiceTest {

    @Test
    fun callList() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val routingNumberService = client.routingNumbers()
        val routingNumberList =
            routingNumberService.list(
                RoutingNumberListParams.builder().routingNumber("xxxxxxxxx").build()
            )
        println(routingNumberList)
        routingNumberList.data().forEach { it.validate() }
    }
}
