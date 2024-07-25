// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.apache.hc.core5.http.ContentType
import software.elborai.api.core.ContentTypes
import software.elborai.api.core.JsonNull
import software.elborai.api.core.JsonString
import software.elborai.api.core.JsonValue
import software.elborai.api.core.MultipartFormValue
import software.elborai.api.models.*
import software.elborai.api.models.SimulationPhysicalCardShipmentAdvanceParams
import software.elborai.api.models.SimulationPhysicalCardShipmentAdvanceParams.SimulationPhysicalCardShipmentAdvanceBody

class SimulationPhysicalCardShipmentAdvanceParamsTest {

    @Test
    fun createSimulationPhysicalCardShipmentAdvanceParams() {
      SimulationPhysicalCardShipmentAdvanceParams.builder()
          .physicalCardId("physical_card_id")
          .shipmentStatus(SimulationPhysicalCardShipmentAdvanceParams.ShipmentStatus.PENDING)
          .build()
    }

    @Test
    fun getBody() {
      val params = SimulationPhysicalCardShipmentAdvanceParams.builder()
          .physicalCardId("physical_card_id")
          .shipmentStatus(SimulationPhysicalCardShipmentAdvanceParams.ShipmentStatus.PENDING)
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.shipmentStatus()).isEqualTo(SimulationPhysicalCardShipmentAdvanceParams.ShipmentStatus.PENDING)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = SimulationPhysicalCardShipmentAdvanceParams.builder()
          .physicalCardId("physical_card_id")
          .shipmentStatus(SimulationPhysicalCardShipmentAdvanceParams.ShipmentStatus.PENDING)
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.shipmentStatus()).isEqualTo(SimulationPhysicalCardShipmentAdvanceParams.ShipmentStatus.PENDING)
    }

    @Test
    fun getPathParam() {
      val params = SimulationPhysicalCardShipmentAdvanceParams.builder()
          .physicalCardId("physical_card_id")
          .shipmentStatus(SimulationPhysicalCardShipmentAdvanceParams.ShipmentStatus.PENDING)
          .build()
      assertThat(params).isNotNull
      // path param "physicalCardId"
      assertThat(params.getPathParam(0)).isEqualTo("physical_card_id")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
