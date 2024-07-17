// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.intrafi

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*
import software.elborai.api.models.IntrafiExclusionListParams

@ExtendWith(TestServerExtension::class)
class ExclusionServiceTest {

    @Test
    fun callCreate() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val exclusionService = client.intrafi().exclusions()
        val intrafiExclusion =
            exclusionService.create(
                IntrafiExclusionCreateParams.builder().bankName("x").entityId("string").build()
            )
        println(intrafiExclusion)
        intrafiExclusion.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val exclusionService = client.intrafi().exclusions()
        val intrafiExclusion =
            exclusionService.retrieve(
                IntrafiExclusionRetrieveParams.builder().intrafiExclusionId("string").build()
            )
        println(intrafiExclusion)
        intrafiExclusion.validate()
    }

    @Test
    fun callList() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val exclusionService = client.intrafi().exclusions()
        val intrafiExclusionList =
            exclusionService.list(IntrafiExclusionListParams.builder().build())
        println(intrafiExclusionList)
        intrafiExclusionList.data().forEach { it.validate() }
    }

    @Test
    fun callArchive() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val exclusionService = client.intrafi().exclusions()
        val intrafiExclusion =
            exclusionService.archive(
                IntrafiExclusionArchiveParams.builder().intrafiExclusionId("string").build()
            )
        println(intrafiExclusion)
        intrafiExclusion.validate()
    }
}
