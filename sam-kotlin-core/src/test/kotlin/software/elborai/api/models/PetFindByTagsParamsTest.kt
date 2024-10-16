// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class PetFindByTagsParamsTest {

    @Test
    fun createPetFindByTagsParams() {
        PetFindByTagsParams.builder().tags(listOf("string")).build()
    }

    @Test
    fun getQueryParams() {
        val params = PetFindByTagsParams.builder().tags(listOf("string")).build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("tags", listOf("string"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = PetFindByTagsParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
