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
import software.elborai.api.models.RealTimeDecisionRetrieveParams

class RealTimeDecisionRetrieveParamsTest {

    @Test
    fun createRealTimeDecisionRetrieveParams() {
      RealTimeDecisionRetrieveParams.builder()
          .realTimeDecisionId("real_time_decision_id")
          .build()
    }

    @Test
    fun getPathParam() {
      val params = RealTimeDecisionRetrieveParams.builder()
          .realTimeDecisionId("real_time_decision_id")
          .build()
      assertThat(params).isNotNull
      // path param "realTimeDecisionId"
      assertThat(params.getPathParam(0)).isEqualTo("real_time_decision_id")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
