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
import software.elborai.api.models.AgentConfigRetrieveParams

class AgentConfigRetrieveParamsTest {

    @Test
    fun createAgentConfigRetrieveParams() {
      AgentConfigRetrieveParams.builder()
          .agentId("string")
          .integration(AgentConfigRetrieveParams.Integration.SALESFORCE)
          .build()
    }

    @Test
    fun getPathParam() {
      val params = AgentConfigRetrieveParams.builder()
          .agentId("string")
          .integration(AgentConfigRetrieveParams.Integration.SALESFORCE)
          .build()
      assertThat(params).isNotNull
      // path param "agentId"
      assertThat(params.getPathParam(0)).isEqualTo("string")
      // path param "integration"
      assertThat(params.getPathParam(1)).isEqualTo(AgentConfigRetrieveParams.Integration.SALESFORCE.toString())
      // out-of-bound path param
      assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
