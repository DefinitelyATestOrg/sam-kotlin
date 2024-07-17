// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*
import software.elborai.api.models.DigitalWalletTokenListParams

@ExtendWith(TestServerExtension::class)
class DigitalWalletTokenServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val digitalWalletTokenService = client.digitalWalletTokens()
        val digitalWalletToken =
            digitalWalletTokenService.retrieve(
                DigitalWalletTokenRetrieveParams.builder()
                    .digitalWalletTokenId("digital_wallet_token_id")
                    .build()
            )
        println(digitalWalletToken)
        digitalWalletToken.validate()
    }

    @Test
    fun callList() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val digitalWalletTokenService = client.digitalWalletTokens()
        val digitalWalletTokenList =
            digitalWalletTokenService.list(DigitalWalletTokenListParams.builder().build())
        println(digitalWalletTokenList)
        digitalWalletTokenList.data().forEach { it.validate() }
    }
}
