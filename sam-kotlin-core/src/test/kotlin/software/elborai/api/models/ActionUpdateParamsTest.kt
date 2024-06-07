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
import software.elborai.api.models.ActionUpdateParams
import software.elborai.api.models.ActionUpdateParams.ActionUpdateBody

class ActionUpdateParamsTest {

    @Test
    fun createActionUpdateParams() {
      ActionUpdateParams.builder()
          .actionId("string")
          .actionSetId("string")
          .agentId("string")
          .createdBy(ActionUpdateParams.CreatedBy.builder()
              .id("string")
              .name("string")
              .build())
          .description("string")
          .errorMessage("string")
          .method(ActionUpdateParams.Method.GET)
          .name("string")
          .parameters(listOf(ActionUpdateParams.Parameter.builder()
              .description("string")
              .errorMessage("string")
              .name("string")
              .required(true)
              .status(ActionUpdateParams.Parameter.Status.USER_CONTEXT)
              .type(ActionUpdateParams.Parameter.Type.PATH)
              .validationType(ActionUpdateParams.Parameter.ValidationType.STRING)
              .build()))
          .path("string")
          .requestBodyType(ActionUpdateParams.RequestBodyType.JSON)
          .status(ActionUpdateParams.Status.ACTIVE)
          .updatedBy(ActionUpdateParams.UpdatedBy.builder()
              .id("string")
              .name("string")
              .build())
          .build()
    }

    @Test
    fun getBody() {
      val params = ActionUpdateParams.builder()
          .actionId("string")
          .actionSetId("string")
          .agentId("string")
          .createdBy(ActionUpdateParams.CreatedBy.builder()
              .id("string")
              .name("string")
              .build())
          .description("string")
          .errorMessage("string")
          .method(ActionUpdateParams.Method.GET)
          .name("string")
          .parameters(listOf(ActionUpdateParams.Parameter.builder()
              .description("string")
              .errorMessage("string")
              .name("string")
              .required(true)
              .status(ActionUpdateParams.Parameter.Status.USER_CONTEXT)
              .type(ActionUpdateParams.Parameter.Type.PATH)
              .validationType(ActionUpdateParams.Parameter.ValidationType.STRING)
              .build()))
          .path("string")
          .requestBodyType(ActionUpdateParams.RequestBodyType.JSON)
          .status(ActionUpdateParams.Status.ACTIVE)
          .updatedBy(ActionUpdateParams.UpdatedBy.builder()
              .id("string")
              .name("string")
              .build())
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.actionSetId()).isEqualTo("string")
      assertThat(body.agentId()).isEqualTo("string")
      assertThat(body.createdBy()).isEqualTo(ActionUpdateParams.CreatedBy.builder()
          .id("string")
          .name("string")
          .build())
      assertThat(body.description()).isEqualTo("string")
      assertThat(body.errorMessage()).isEqualTo("string")
      assertThat(body.method()).isEqualTo(ActionUpdateParams.Method.GET)
      assertThat(body.name()).isEqualTo("string")
      assertThat(body.parameters()).isEqualTo(listOf(ActionUpdateParams.Parameter.builder()
          .description("string")
          .errorMessage("string")
          .name("string")
          .required(true)
          .status(ActionUpdateParams.Parameter.Status.USER_CONTEXT)
          .type(ActionUpdateParams.Parameter.Type.PATH)
          .validationType(ActionUpdateParams.Parameter.ValidationType.STRING)
          .build()))
      assertThat(body.path()).isEqualTo("string")
      assertThat(body.requestBodyType()).isEqualTo(ActionUpdateParams.RequestBodyType.JSON)
      assertThat(body.status()).isEqualTo(ActionUpdateParams.Status.ACTIVE)
      assertThat(body.updatedBy()).isEqualTo(ActionUpdateParams.UpdatedBy.builder()
          .id("string")
          .name("string")
          .build())
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = ActionUpdateParams.builder()
          .actionId("string")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
      val params = ActionUpdateParams.builder()
          .actionId("string")
          .build()
      assertThat(params).isNotNull
      // path param "actionId"
      assertThat(params.getPathParam(0)).isEqualTo("string")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
