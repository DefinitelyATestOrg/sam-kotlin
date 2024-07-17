// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*
import software.elborai.api.models.LockboxListParams

@ExtendWith(TestServerExtension::class)
class LockboxServiceTest {

    @Test
    fun callCreate() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val lockboxService = client.lockboxes()
        val lockbox =
            lockboxService.create(
                LockboxCreateParams.builder().accountId("string").description("x").build()
            )
        println(lockbox)
        lockbox.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val lockboxService = client.lockboxes()
        val lockbox =
            lockboxService.retrieve(LockboxRetrieveParams.builder().lockboxId("string").build())
        println(lockbox)
        lockbox.validate()
    }

    @Test
    fun callUpdate() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val lockboxService = client.lockboxes()
        val lockbox =
            lockboxService.update(
                LockboxUpdateParams.builder()
                    .lockboxId("string")
                    .description("x")
                    .status(LockboxUpdateParams.Status.ACTIVE)
                    .build()
            )
        println(lockbox)
        lockbox.validate()
    }

    @Test
    fun callList() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val lockboxService = client.lockboxes()
        val lockboxList = lockboxService.list(LockboxListParams.builder().build())
        println(lockboxList)
        lockboxList.data().forEach { it.validate() }
    }
}
