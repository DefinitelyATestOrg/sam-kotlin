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
import software.elborai.api.models.PhysicalCardProfileCreateParams
import software.elborai.api.models.PhysicalCardProfileCreateParams.PhysicalCardProfileCreateBody

class PhysicalCardProfileCreateParamsTest {

    @Test
    fun createPhysicalCardProfileCreateParams() {
      PhysicalCardProfileCreateParams.builder()
          .carrierImageFileId("carrier_image_file_id")
          .contactPhone("x")
          .description("x")
          .frontImageFileId("front_image_file_id")
          .build()
    }

    @Test
    fun getBody() {
      val params = PhysicalCardProfileCreateParams.builder()
          .carrierImageFileId("carrier_image_file_id")
          .contactPhone("x")
          .description("x")
          .frontImageFileId("front_image_file_id")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.carrierImageFileId()).isEqualTo("carrier_image_file_id")
      assertThat(body.contactPhone()).isEqualTo("x")
      assertThat(body.description()).isEqualTo("x")
      assertThat(body.frontImageFileId()).isEqualTo("front_image_file_id")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = PhysicalCardProfileCreateParams.builder()
          .carrierImageFileId("carrier_image_file_id")
          .contactPhone("x")
          .description("x")
          .frontImageFileId("front_image_file_id")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.carrierImageFileId()).isEqualTo("carrier_image_file_id")
      assertThat(body.contactPhone()).isEqualTo("x")
      assertThat(body.description()).isEqualTo("x")
      assertThat(body.frontImageFileId()).isEqualTo("front_image_file_id")
    }
}
