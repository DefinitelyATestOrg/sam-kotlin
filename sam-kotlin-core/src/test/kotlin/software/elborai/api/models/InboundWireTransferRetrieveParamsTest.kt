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
import software.elborai.api.models.InboundWireTransferRetrieveParams

class InboundWireTransferRetrieveParamsTest {

    @Test
    fun createInboundWireTransferRetrieveParams() {
      InboundWireTransferRetrieveParams.builder()
          .inboundWireTransferId("inbound_wire_transfer_id")
          .build()
    }

    @Test
    fun getPathParam() {
      val params = InboundWireTransferRetrieveParams.builder()
          .inboundWireTransferId("inbound_wire_transfer_id")
          .build()
      assertThat(params).isNotNull
      // path param "inboundWireTransferId"
      assertThat(params.getPathParam(0)).isEqualTo("inbound_wire_transfer_id")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
