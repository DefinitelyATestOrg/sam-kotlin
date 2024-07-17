// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*
import software.elborai.api.models.OAuthConnectionListParams

@ExtendWith(TestServerExtension::class)
class OAuthConnectionServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val oauthConnectionService = client.oauthConnections()
        val oauthConnection =
            oauthConnectionService.retrieve(
                OAuthConnectionRetrieveParams.builder().oauthConnectionId("string").build()
            )
        println(oauthConnection)
        oauthConnection.validate()
    }

    @Test
    fun callList() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val oauthConnectionService = client.oauthConnections()
        val oauthConnectionList =
            oauthConnectionService.list(OAuthConnectionListParams.builder().build())
        println(oauthConnectionList)
        oauthConnectionList.data().forEach { it.validate() }
    }
}
