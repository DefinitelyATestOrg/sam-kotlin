// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class PetFindByStatusParamsTest {

    @Test
    fun createPetFindByStatusParams() {
        PetFindByStatusParams.builder().status(PetFindByStatusParams.Status.AVAILABLE).build()
    }

    @Test
    fun getQueryParams() {
        val params =
            PetFindByStatusParams.builder().status(PetFindByStatusParams.Status.AVAILABLE).build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("status", listOf(PetFindByStatusParams.Status.AVAILABLE.toString()))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = PetFindByStatusParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
