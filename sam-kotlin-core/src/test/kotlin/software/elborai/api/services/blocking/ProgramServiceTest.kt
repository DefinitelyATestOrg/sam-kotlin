// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*
import software.elborai.api.models.ProgramListParams

@ExtendWith(TestServerExtension::class)
class ProgramServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val programService = client.programs()
        val program =
            programService.retrieve(ProgramRetrieveParams.builder().programId("program_id").build())
        println(program)
        program.validate()
    }

    @Test
    fun callList() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val programService = client.programs()
        val programList = programService.list(ProgramListParams.builder().build())
        println(programList)
        programList.data().forEach { it.validate() }
    }
}
