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
import software.elborai.api.services.blocking.InboundWireDrawdownRequestService
import software.elborai.api.models.InboundWireDrawdownRequestListPage
import software.elborai.api.models.InboundWireDrawdownRequestListParams
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class InboundWireDrawdownRequestServiceTest {

    @Test
    fun callRetrieve() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val inboundWireDrawdownRequestService = client.inboundWireDrawdownRequests()
      val inboundWireDrawdownRequest = inboundWireDrawdownRequestService.retrieve(InboundWireDrawdownRequestRetrieveParams.builder()
          .inboundWireDrawdownRequestId("inbound_wire_drawdown_request_id")
          .build())
      println(inboundWireDrawdownRequest)
      inboundWireDrawdownRequest.validate()
    }

    @Test
    fun callList() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val inboundWireDrawdownRequestService = client.inboundWireDrawdownRequests()
      val inboundWireDrawdownRequestList = inboundWireDrawdownRequestService.list(InboundWireDrawdownRequestListParams.builder().build())
      println(inboundWireDrawdownRequestList)
      inboundWireDrawdownRequestList.data().forEach {
          it.validate()
      }
    }
}
