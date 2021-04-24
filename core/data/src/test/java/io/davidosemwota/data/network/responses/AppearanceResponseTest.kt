package io.davidosemwota.data.network.responses

import com.google.common.truth.Truth.assertThat
import io.davidosemwota.data.util.generateEyeColor
import io.davidosemwota.data.util.generateGender
import io.davidosemwota.data.util.generateHairColor
import io.davidosemwota.data.util.generateRace
import org.junit.jupiter.api.Test

internal class AppearanceResponseTest {

    @Test
    fun createAppearanceResponse_getCorrectAttributes() {

        val gender = generateGender()
        val race = generateRace()
        val height = listOf("6.1", "185 cm")
        val weight = listOf("22 KG", " 5 pounds")
        val eyeColor = generateEyeColor()
        val hairColor = generateHairColor()


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