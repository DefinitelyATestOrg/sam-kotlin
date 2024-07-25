// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.simulations

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
import software.elborai.api.services.blocking.simulations.CheckDepositService
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class CheckDepositServiceTest {

    @Disabled("Prism incorrectly returns an invalid JSON error")
    @Test
    fun callReject() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val checkDepositService = client.simulations().checkDeposits()
      val checkDeposit = checkDepositService.reject(SimulationCheckDepositRejectParams.builder()
          .checkDepositId("check_deposit_id")
          .build())
      println(checkDeposit)
      checkDeposit.validate()
    }

    @Test
    fun callReturn() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val checkDepositService = client.simulations().checkDeposits()
      val checkDeposit = checkDepositService.return_(SimulationCheckDepositReturnParams.builder()
          .checkDepositId("check_deposit_id")
          .build())
      println(checkDeposit)
      checkDeposit.validate()
    }

    @Disabled("Prism incorrectly returns an invalid JSON error")
    @Test
    fun callSubmit() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val checkDepositService = client.simulations().checkDeposits()
      val checkDeposit = checkDepositService.submit(SimulationCheckDepositSubmitParams.builder()
          .checkDepositId("check_deposit_id")
          .build())
      println(checkDeposit)
      checkDeposit.validate()
    }
}
