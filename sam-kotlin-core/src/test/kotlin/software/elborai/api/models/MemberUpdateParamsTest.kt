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
import software.elborai.api.models.MemberUpdateParams
import software.elborai.api.models.MemberUpdateParams.MemberUpdateBody

class MemberUpdateParamsTest {

    @Test
    fun createMemberUpdateParams() {
      MemberUpdateParams.builder()
          .memberId("string")
          .id("string")
          .email("string")
          .name("string")
          .orgId("string")
          .pictureUrl("string")
          .role(MemberUpdateParams.Role.OWNER)
          .build()
    }

    @Test
    fun getBody() {
      val params = MemberUpdateParams.builder()
          .memberId("string")
          .id("string")
          .email("string")
          .name("string")
          .orgId("string")
          .pictureUrl("string")
          .role(MemberUpdateParams.Role.OWNER)
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.id()).isEqualTo("string")
      assertThat(body.email()).isEqualTo("string")
      assertThat(body.name()).isEqualTo("string")
      assertThat(body.orgId()).isEqualTo("string")
      assertThat(body.pictureUrl()).isEqualTo("string")
      assertThat(body.role()).isEqualTo(MemberUpdateParams.Role.OWNER)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = MemberUpdateParams.builder()
          .memberId("string")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
      val params = MemberUpdateParams.builder()
          .memberId("string")
          .build()
      assertThat(params).isNotNull
      // path param "memberId"
      assertThat(params.getPathParam(0)).isEqualTo("string")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
