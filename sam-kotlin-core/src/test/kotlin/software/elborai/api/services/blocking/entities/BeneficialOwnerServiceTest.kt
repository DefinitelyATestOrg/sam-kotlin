// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.entities

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
import software.elborai.api.services.blocking.entities.BeneficialOwnerService
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class BeneficialOwnerServiceTest {

    @Test
    fun callCreate() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val beneficialOwnerService = client.entities().beneficialOwners()
      val entity = beneficialOwnerService.create(EntityBeneficialOwnerCreateParams.builder()
          .beneficialOwner(EntityBeneficialOwnerCreateParams.BeneficialOwner.builder()
              .individual(EntityBeneficialOwnerCreateParams.BeneficialOwner.Individual.builder()
                  .address(EntityBeneficialOwnerCreateParams.BeneficialOwner.Individual.Address.builder()
                      .city("x")
                      .line1("x")
                      .state("x")
                      .zip("x")
                      .line2("x")
                      .build())
                  .dateOfBirth(LocalDate.parse("2019-12-27"))
                  .identification(EntityBeneficialOwnerCreateParams.BeneficialOwner.Individual.Identification.builder()
                      .method(EntityBeneficialOwnerCreateParams.BeneficialOwner.Individual.Identification.Method.SOCIAL_SECURITY_NUMBER)
                      .number("xxxx")
                      .driversLicense(EntityBeneficialOwnerCreateParams.BeneficialOwner.Individual.Identification.DriversLicense.builder()
                          .expirationDate(LocalDate.parse("2019-12-27"))
                          .fileId("file_id")
                          .state("x")
                          .backFileId("back_file_id")
                          .build())
                      .other(EntityBeneficialOwnerCreateParams.BeneficialOwner.Individual.Identification.Other.builder()
                          .country("x")
                          .description("x")
                          .fileId("file_id")
                          .backFileId("back_file_id")
                          .expirationDate(LocalDate.parse("2019-12-27"))
                          .build())
                      .passport(EntityBeneficialOwnerCreateParams.BeneficialOwner.Individual.Identification.Passport.builder()
                          .country("x")
                          .expirationDate(LocalDate.parse("2019-12-27"))
                          .fileId("file_id")
                          .build())
                      .build())
                  .name("x")
                  .confirmedNoUsTaxId(true)
                  .build())
              .prongs(listOf(EntityBeneficialOwnerCreateParams.BeneficialOwner.Prong.OWNERSHIP))
              .companyTitle("x")
              .build())
          .entityId("entity_id")
          .build())
      println(entity)
      entity.validate()
    }

    @Test
    fun callArchive() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val beneficialOwnerService = client.entities().beneficialOwners()
      val entity = beneficialOwnerService.archive(EntityBeneficialOwnerArchiveParams.builder()
          .beneficialOwnerId("beneficial_owner_id")
          .entityId("entity_id")
          .build())
      println(entity)
      entity.validate()
    }

    @Test
    fun callUpdateAddress() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val beneficialOwnerService = client.entities().beneficialOwners()
      val entity = beneficialOwnerService.updateAddress(EntityBeneficialOwnerUpdateAddressParams.builder()
          .address(EntityBeneficialOwnerUpdateAddressParams.Address.builder()
              .city("x")
              .line1("x")
              .state("x")
              .zip("x")
              .line2("x")
              .build())
          .beneficialOwnerId("beneficial_owner_id")
          .entityId("entity_id")
          .build())
      println(entity)
      entity.validate()
    }
}
