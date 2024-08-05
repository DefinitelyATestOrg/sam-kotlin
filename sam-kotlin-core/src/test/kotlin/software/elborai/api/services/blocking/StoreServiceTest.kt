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
import software.elborai.api.services.blocking.StoreService
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class StoreServiceTest {

    @Test
    fun callRetrieve() {
      val client = SamOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .build()
      val storeService = client.stores()
      val order = storeService.retrieve(StoreRetrieveParams.builder()
          .orderId(123L)
          .build())
      println(order)
      order.validate()
    }

    @Test
    fun callDelete() {
      val client = SamOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .build()
      val storeService = client.stores()
      storeService.delete(StoreDeleteParams.builder()
          .orderId(123L)
          .build())
    }

    @Test
    fun callCreateOrder() {
      val client = SamOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .build()
      val storeService = client.stores()
      val order = storeService.createOrder(StoreCreateOrderParams.builder()
          .id(123L)
          .complete(true)
          .petId(123L)
          .quantity(123L)
          .shipDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .status(StoreCreateOrderParams.Status.PLACED)
          .build())
      println(order)
      order.validate()
    }

    @Test
    fun callInventory() {
      val client = SamOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .build()
      val storeService = client.stores()
      val storeInventoryResponse = storeService.inventory(StoreInventoryParams.builder().build())
      println(storeInventoryResponse)
      storeInventoryResponse.validate()
    }
}
