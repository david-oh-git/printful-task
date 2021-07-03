package io.davidosemwota.data.network.responses

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

internal class BiographyResponseTest {

    @Test
    fun createBiographyResponse_getCorrectAttributes() {

        val fullName = "Captain Afika"
        val alignment = "alignment"
        val alterEgos = "Ogunbade BabaTunde"
        val firstAppearance = "Captain Afrika issue 2"
        val placeOfBirth = "Ota Ogun state"
        val publisher = "Iyalode books"
        val aliases = listOf("The fist of wokombo")

        val biographyResponse = BiographyResponse(
            fullName = fullName,
            aliases = aliases,
            alignment = alignment,
            alterEgos = alterEgos,
            firstAppearance = firstAppearance,
            placeOfBirth = placeOfBirth,
            publisher = publisher
        )

        assertThat(biographyResponse.fullName).isEqualTo(fullName)
        assertThat(biographyResponse.aliases.size).isEqualTo(aliases.size)
        assertThat(biographyResponse.alignment).isEqualTo(alignment)
        assertThat(biographyResponse.alterEgos).isEqualTo(alterEgos)
        assertThat(biographyResponse.firstAppearance).isEqualTo(firstAppearance)
        assertThat(biographyResponse.placeOfBirth).isEqualTo(placeOfBirth)
        assertThat(biographyResponse.publisher).isEqualTo(publisher)
    }
}