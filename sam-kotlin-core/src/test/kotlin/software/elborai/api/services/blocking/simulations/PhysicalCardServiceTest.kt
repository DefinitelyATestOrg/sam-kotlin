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
import software.elborai.api.services.blocking.simulations.PhysicalCardService
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class PhysicalCardServiceTest {

    @Test
    fun callShipmentAdvance() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val physicalCardService = client.simulations().physicalCards()
      val physicalCard = physicalCardService.shipmentAdvance(SimulationPhysicalCardShipmentAdvanceParams.builder()
          .physicalCardId("physical_card_id")
          .shipmentStatus(SimulationPhysicalCardShipmentAdvanceParams.ShipmentStatus.PENDING)
          .build())
      println(physicalCard)
      physicalCard.validate()
    }
}
