// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class PetUploadImageParamsTest {

    @Test
    fun createPetUploadImageParams() {
        PetUploadImageParams.builder()
            .petId(123L)
            .body("some content")
            .additionalMetadata("additionalMetadata")
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            PetUploadImageParams.builder()
                .petId(123L)
                .body("some content")
                .additionalMetadata("additionalMetadata")
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("additionalMetadata", listOf("additionalMetadata"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = PetUploadImageParams.builder().petId(123L).body("some content").build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            PetUploadImageParams.builder()
                .petId(123L)
                .body("some content")
                .additionalMetadata("additionalMetadata")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body).isEqualTo("some content")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = PetUploadImageParams.builder().petId(123L).body("some content").build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body).isEqualTo("some content")
    }

    @Test
    fun getPathParam() {
        val params = PetUploadImageParams.builder().petId(123L).body("some content").build()
        assertThat(params).isNotNull
        // path param "petId"
        assertThat(params.getPathParam(0)).isEqualTo("123")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
