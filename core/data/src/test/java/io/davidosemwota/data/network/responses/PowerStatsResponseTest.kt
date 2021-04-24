package io.davidosemwota.data.network.responses

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test


internal class PowerStatsResponseTest {

    @Test
    fun createPowerStatResponse_getCorrectAttributes() {

        val intelligence = 71
        val combat = 89
        val durability = 91
        val power = 77
        val speed = 69
        val strength = 90

        val powerStatsResponse = PowerStatsResponse(
                intelligence = intelligence,
                combat = combat,
                durability = durability,
                power = power,
                speed = speed,
                strength = strength
        )

        assertThat(powerStatsResponse.combat).isEqualTo(combat)
        assertThat(powerStatsResponse.intelligence).isEqualTo(intelligence)
        assertThat(powerStatsResponse.durability).isEqualTo(durability)
        assertThat(powerStatsResponse.power).isEqualTo(power)
        assertThat(powerStatsResponse.speed).isEqualTo(speed)
        assertThat(powerStatsResponse.strength).isEqualTo(strength)
    }
}