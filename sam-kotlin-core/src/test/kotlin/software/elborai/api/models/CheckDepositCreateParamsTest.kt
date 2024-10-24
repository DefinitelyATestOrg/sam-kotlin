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
import software.elborai.api.models.CheckDepositCreateParams
import software.elborai.api.models.CheckDepositCreateParams.CheckDepositCreateBody

class CheckDepositCreateParamsTest {

    @Test
    fun createCheckDepositCreateParams() {
      CheckDepositCreateParams.builder()
          .accountId("account_id")
          .amount(123L)
          .backImageFileId("back_image_file_id")
          .frontImageFileId("front_image_file_id")
          .description("x")
          .build()
    }

    @Test
    fun getBody() {
      val params = CheckDepositCreateParams.builder()
          .accountId("account_id")
          .amount(123L)
          .backImageFileId("back_image_file_id")
          .frontImageFileId("front_image_file_id")
          .description("x")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.accountId()).isEqualTo("account_id")
      assertThat(body.amount()).isEqualTo(123L)
      assertThat(body.backImageFileId()).isEqualTo("back_image_file_id")
      assertThat(body.frontImageFileId()).isEqualTo("front_image_file_id")
      assertThat(body.description()).isEqualTo("x")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = CheckDepositCreateParams.builder()
          .accountId("account_id")
          .amount(123L)
          .backImageFileId("back_image_file_id")
          .frontImageFileId("front_image_file_id")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.accountId()).isEqualTo("account_id")
      assertThat(body.amount()).isEqualTo(123L)
      assertThat(body.backImageFileId()).isEqualTo("back_image_file_id")
      assertThat(body.frontImageFileId()).isEqualTo("front_image_file_id")
    }
}
