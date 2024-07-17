// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class EntityRetrieveParamsTest {

    @Test
    fun createEntityRetrieveParams() {
        EntityRetrieveParams.builder().entityId("entity_id").build()
    }

    @Test
    fun getPathParam() {
        val params = EntityRetrieveParams.builder().entityId("entity_id").build()
        assertThat(params).isNotNull
        // path param "entityId"
        assertThat(params.getPathParam(0)).isEqualTo("entity_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
