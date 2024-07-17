// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.simulations

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class PhysicalCardServiceTest {

    @Test
    fun callShipmentAdvance() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val physicalCardService = client.simulations().physicalCards()
        val physicalCard =
            physicalCardService.shipmentAdvance(
                SimulationPhysicalCardShipmentAdvanceParams.builder()
                    .physicalCardId("physical_card_id")
                    .shipmentStatus(
                        SimulationPhysicalCardShipmentAdvanceParams.ShipmentStatus.PENDING
                    )
                    .build()
            )
        println(physicalCard)
        physicalCard.validate()
    }
}
