// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

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
import software.elborai.api.client.SamClient
import software.elborai.api.client.okhttp.SamOkHttpClient
import software.elborai.api.core.JsonNull
import software.elborai.api.core.JsonString
import software.elborai.api.core.JsonValue
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.services.blocking.PetService
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class PetServiceTest {

    @Test
    fun callCreate() {
      val client = SamOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .build()
      val petService = client.pets()
      petService.create(PetCreateParams.builder()
          .petId(123L)
          .name("name")
          .status("status")
          .build())
    }

    @Test
    fun callRetrieve() {
      val client = SamOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .build()
      val petService = client.pets()
      val pet = petService.retrieve(PetRetrieveParams.builder()
          .petId(123L)
          .build())
      println(pet)
      pet.validate()
    }

    @Test
    fun callUpdate() {
      val client = SamOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .build()
      val petService = client.pets()
      val pet = petService.update(PetUpdateParams.builder()
          .name("doggie")
          .photoUrls(listOf("string"))
          .id(123L)
          .category(PetUpdateParams.Category.builder()
              .id(123L)
              .name("Dogs")
              .build())
          .status(PetUpdateParams.Status.AVAILABLE)
          .tags(listOf(PetUpdateParams.Tag.builder()
              .id(123L)
              .name("name")
              .build()))
          .build())
      println(pet)
      pet.validate()
    }

    @Test
    fun callDelete() {
      val client = SamOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .build()
      val petService = client.pets()
      petService.delete(PetDeleteParams.builder()
          .petId(123L)
          .build())
    }

    @Test
    fun callFindByStatus() {
      val client = SamOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .build()
      val petService = client.pets()
      val petFindByStatusResponse = petService.findByStatus(PetFindByStatusParams.builder()
          .status(PetFindByStatusParams.Status.AVAILABLE)
          .build())
      println(petFindByStatusResponse)
      for (pet: Pet in petFindByStatusResponse) {
          pet.validate()
      }
    }

    @Test
    fun callFindByTags() {
      val client = SamOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .build()
      val petService = client.pets()
      val petFindByTagsResponse = petService.findByTags(PetFindByTagsParams.builder()
          .tags(listOf("string"))
          .build())
      println(petFindByTagsResponse)
      for (pet: Pet in petFindByTagsResponse) {
          pet.validate()
      }
    }

    @Test
    fun callUploadImage() {
      val client = SamOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .build()
      val petService = client.pets()
      val apiResponse = petService.uploadImage(PetUploadImageParams.builder()
          .petId(123L)
          .body("some content")
          .additionalMetadata("additionalMetadata")
          .build())
      println(apiResponse)
      apiResponse.validate()
    }
}
