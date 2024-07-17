// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class OAuthTokenServiceTest {

    @Test
    fun callCreate() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val oauthTokenService = client.oauthTokens()
        val oauthToken =
            oauthTokenService.create(
                OAuthTokenCreateParams.builder()
                    .grantType(OAuthTokenCreateParams.GrantType.AUTHORIZATION_CODE)
                    .clientId("x")
                    .clientSecret("x")
                    .code("x")
                    .productionToken("x")
                    .build()
            )
        println(oauthToken)
        oauthToken.validate()
    }
}
