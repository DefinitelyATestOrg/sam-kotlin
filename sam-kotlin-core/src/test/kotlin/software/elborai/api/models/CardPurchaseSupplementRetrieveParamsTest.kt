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
import software.elborai.api.models.CardPurchaseSupplementRetrieveParams

class CardPurchaseSupplementRetrieveParamsTest {

    @Test
    fun createCardPurchaseSupplementRetrieveParams() {
      CardPurchaseSupplementRetrieveParams.builder()
          .cardPurchaseSupplementId("card_purchase_supplement_id")
          .build()
    }

    @Test
    fun getPathParam() {
      val params = CardPurchaseSupplementRetrieveParams.builder()
          .cardPurchaseSupplementId("card_purchase_supplement_id")
          .build()
      assertThat(params).isNotNull
      // path param "cardPurchaseSupplementId"
      assertThat(params.getPathParam(0)).isEqualTo("card_purchase_supplement_id")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
