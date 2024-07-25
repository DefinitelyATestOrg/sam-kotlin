// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class PetUpdateParamsTest {

    @Test
    fun createPetUpdateParams() {
        PetUpdateParams.builder()
            .name("doggie")
            .photoUrls(listOf("string"))
            .id(123L)
            .category(PetUpdateParams.Category.builder().id(123L).name("Dogs").build())
            .status(PetUpdateParams.Status.AVAILABLE)
            .tags(listOf(PetUpdateParams.Tag.builder().id(123L).name("name").build()))
            .build()
    }

    @Test
    fun getBody() {
        val params =
            PetUpdateParams.builder()
                .name("doggie")
                .photoUrls(listOf("string"))
                .id(123L)
                .category(PetUpdateParams.Category.builder().id(123L).name("Dogs").build())
                .status(PetUpdateParams.Status.AVAILABLE)
                .tags(listOf(PetUpdateParams.Tag.builder().id(123L).name("name").build()))
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.name()).isEqualTo("doggie")
        assertThat(body.photoUrls()).isEqualTo(listOf("string"))
        assertThat(body.id()).isEqualTo(123L)
        assertThat(body.category())
            .isEqualTo(PetUpdateParams.Category.builder().id(123L).name("Dogs").build())
        assertThat(body.status()).isEqualTo(PetUpdateParams.Status.AVAILABLE)
        assertThat(body.tags())
            .isEqualTo(listOf(PetUpdateParams.Tag.builder().id(123L).name("name").build()))
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = PetUpdateParams.builder().name("doggie").photoUrls(listOf("string")).build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.name()).isEqualTo("doggie")
        assertThat(body.photoUrls()).isEqualTo(listOf("string"))
    }
}
