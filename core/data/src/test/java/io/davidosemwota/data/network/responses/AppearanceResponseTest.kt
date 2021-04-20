package io.davidosemwota.data.network.responses

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

internal class AppearanceResponseTest {

    @Test
    fun createAppearanceResponse_getCorrectAttributes() {

        val gender = "Female"
        val race = "African"
        val height = listOf("6.1", "185 cm")
        val weight = listOf("22 KG", " 5 pounds")
        val eyeColor = "green"
        val hairColor = "purple"


        val appearanceResponse = AppearanceResponse(
            gender = gender,
            race = race,
            height = height,
            weight = weight,
            eyeColor = eyeColor,
            hairColor = hairColor
        )

        assertThat(appearanceResponse.eyeColor).isEqualTo(eyeColor)
        assertThat(appearanceResponse.hairColor).isEqualTo(hairColor)
        assertThat(appearanceResponse.gender).isEqualTo(gender)
        assertThat(appearanceResponse.race).isEqualTo(race)
        assertThat(appearanceResponse.height.size).isEqualTo(height.size)
        assertThat(appearanceResponse.weight.size).isEqualTo(weight.size)
    }
}