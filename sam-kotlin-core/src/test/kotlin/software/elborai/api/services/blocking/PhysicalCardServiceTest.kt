// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*
import software.elborai.api.models.PhysicalCardListParams

@ExtendWith(TestServerExtension::class)
class PhysicalCardServiceTest {

    @Test
    fun callCreate() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val physicalCardService = client.physicalCards()
        val physicalCard =
            physicalCardService.create(
                PhysicalCardCreateParams.builder()
                    .cardId("string")
                    .cardholder(
                        PhysicalCardCreateParams.Cardholder.builder()
                            .firstName("x")
                            .lastName("x")
                            .build()
                    )
                    .shipment(
                        PhysicalCardCreateParams.Shipment.builder()
                            .address(
                                PhysicalCardCreateParams.Shipment.Address.builder()
                                    .city("x")
                                    .line1("x")
                                    .name("x")
                                    .postalCode("x")
                                    .state("x")
                                    .line2("x")
                                    .line3("x")
                                    .phoneNumber("x")
                                    .build()
                            )
                            .method(PhysicalCardCreateParams.Shipment.Method.USPS)
                            .build()
                    )
                    .physicalCardProfileId("string")
                    .build()
            )
        println(physicalCard)
        physicalCard.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val physicalCardService = client.physicalCards()
        val physicalCard =
            physicalCardService.retrieve(
                PhysicalCardRetrieveParams.builder().physicalCardId("string").build()
            )
        println(physicalCard)
        physicalCard.validate()
    }

    @Test
    fun callUpdate() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val physicalCardService = client.physicalCards()
        val physicalCard =
            physicalCardService.update(
                PhysicalCardUpdateParams.builder()
                    .physicalCardId("string")
                    .status(PhysicalCardUpdateParams.Status.ACTIVE)
                    .build()
            )
        println(physicalCard)
        physicalCard.validate()
    }

    @Test
    fun callList() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val physicalCardService = client.physicalCards()
        val physicalCardList = physicalCardService.list(PhysicalCardListParams.builder().build())
        println(physicalCardList)
        physicalCardList.data().forEach { it.validate() }
    }
}
