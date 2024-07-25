// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PetTest {

    @Test
    fun createPet() {
        val pet =
            Pet.builder()
                .name("doggie")
                .photoUrls(listOf("string"))
                .id(123L)
                .category(Pet.Category.builder().id(123L).name("Dogs").build())
                .status(Pet.Status.AVAILABLE)
                .tags(listOf(Pet.Tag.builder().id(123L).name("name").build()))
                .build()
        assertThat(pet).isNotNull
        assertThat(pet.name()).isEqualTo("doggie")
        assertThat(pet.photoUrls()).containsExactly("string")
        assertThat(pet.id()).isEqualTo(123L)
        assertThat(pet.category()).isEqualTo(Pet.Category.builder().id(123L).name("Dogs").build())
        assertThat(pet.status()).isEqualTo(Pet.Status.AVAILABLE)
        assertThat(pet.tags()).containsExactly(Pet.Tag.builder().id(123L).name("name").build())
    }
}
