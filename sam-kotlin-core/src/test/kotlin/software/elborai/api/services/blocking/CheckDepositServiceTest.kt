// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Base64
import java.util.Optional
import java.util.UUID
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.BeforeEach
import software.elborai.api.TestServerExtension
import software.elborai.api.client.IncreaseClient
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.core.JsonNull
import software.elborai.api.core.JsonString
import software.elborai.api.core.JsonValue
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.services.blocking.CheckDepositService
import software.elborai.api.models.CheckDepositListPage
import software.elborai.api.models.CheckDepositListParams
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class CheckDepositServiceTest {

    @Test
    fun callCreate() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val checkDepositService = client.checkDeposits()
      val checkDeposit = checkDepositService.create(CheckDepositCreateParams.builder()
          .accountId("account_id")
          .amount(123L)
          .backImageFileId("back_image_file_id")
          .frontImageFileId("front_image_file_id")
          .description("x")
          .build())
      println(checkDeposit)
      checkDeposit.validate()
    }

    @Test
    fun callRetrieve() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val checkDepositService = client.checkDeposits()
      val checkDeposit = checkDepositService.retrieve(CheckDepositRetrieveParams.builder()
          .checkDepositId("check_deposit_id")
          .build())
      println(checkDeposit)
      checkDeposit.validate()
    }

    @Test
    fun callList() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val checkDepositService = client.checkDeposits()
      val checkDepositList = checkDepositService.list(CheckDepositListParams.builder().build())
      println(checkDepositList)
      checkDepositList.data().forEach {
          it.validate()
      }
    }
}
