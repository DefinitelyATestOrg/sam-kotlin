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
import software.elborai.api.models.PhysicalCardCreateParams
import software.elborai.api.models.PhysicalCardCreateParams.PhysicalCardCreateBody

class PhysicalCardCreateParamsTest {

    @Test
    fun createPhysicalCardCreateParams() {
      PhysicalCardCreateParams.builder()
          .cardId("card_id")
          .cardholder(PhysicalCardCreateParams.Cardholder.builder()
              .firstName("x")
              .lastName("x")
              .build())
          .shipment(PhysicalCardCreateParams.Shipment.builder()
              .address(PhysicalCardCreateParams.Shipment.Address.builder()
                  .city("x")
                  .line1("x")
                  .name("x")
                  .postalCode("x")
                  .state("x")
                  .line2("x")
                  .line3("x")
                  .phoneNumber("x")
                  .build())
              .method(PhysicalCardCreateParams.Shipment.Method.USPS)
              .build())
          .physicalCardProfileId("physical_card_profile_id")
          .build()
    }

    @Test
    fun getBody() {
      val params = PhysicalCardCreateParams.builder()
          .cardId("card_id")
          .cardholder(PhysicalCardCreateParams.Cardholder.builder()
              .firstName("x")
              .lastName("x")
              .build())
          .shipment(PhysicalCardCreateParams.Shipment.builder()
              .address(PhysicalCardCreateParams.Shipment.Address.builder()
                  .city("x")
                  .line1("x")
                  .name("x")
                  .postalCode("x")
                  .state("x")
                  .line2("x")
                  .line3("x")
                  .phoneNumber("x")
                  .build())
              .method(PhysicalCardCreateParams.Shipment.Method.USPS)
              .build())
          .physicalCardProfileId("physical_card_profile_id")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.cardId()).isEqualTo("card_id")
      assertThat(body.cardholder()).isEqualTo(PhysicalCardCreateParams.Cardholder.builder()
          .firstName("x")
          .lastName("x")
          .build())
      assertThat(body.shipment()).isEqualTo(PhysicalCardCreateParams.Shipment.builder()
          .address(PhysicalCardCreateParams.Shipment.Address.builder()
              .city("x")
              .line1("x")
              .name("x")
              .postalCode("x")
              .state("x")
              .line2("x")
              .line3("x")
              .phoneNumber("x")
              .build())
          .method(PhysicalCardCreateParams.Shipment.Method.USPS)
          .build())
      assertThat(body.physicalCardProfileId()).isEqualTo("physical_card_profile_id")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = PhysicalCardCreateParams.builder()
          .cardId("card_id")
          .cardholder(PhysicalCardCreateParams.Cardholder.builder()
              .firstName("x")
              .lastName("x")
              .build())
          .shipment(PhysicalCardCreateParams.Shipment.builder()
              .address(PhysicalCardCreateParams.Shipment.Address.builder()
                  .city("x")
                  .line1("x")
                  .name("x")
                  .postalCode("x")
                  .state("x")
                  .build())
              .method(PhysicalCardCreateParams.Shipment.Method.USPS)
              .build())
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.cardId()).isEqualTo("card_id")
      assertThat(body.cardholder()).isEqualTo(PhysicalCardCreateParams.Cardholder.builder()
          .firstName("x")
          .lastName("x")
          .build())
      assertThat(body.shipment()).isEqualTo(PhysicalCardCreateParams.Shipment.builder()
          .address(PhysicalCardCreateParams.Shipment.Address.builder()
              .city("x")
              .line1("x")
              .name("x")
              .postalCode("x")
              .state("x")
              .build())
          .method(PhysicalCardCreateParams.Shipment.Method.USPS)
          .build())
    }
}
