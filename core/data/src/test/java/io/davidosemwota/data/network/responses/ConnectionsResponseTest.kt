package io.davidosemwota.data.network.responses

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test


internal class ConnectionsResponseTest {

    @Test
    fun createConnectionsResponse_getCorrectAttributes() {

        val groupAffiliation = "The Squad Afro Avengers"
        val relatives = "Baba Segi; Super Dosumu, Egbo Kasim"

        val connectionsResponse = ConnectionsResponse(
            groupAffiliation = groupAffiliation,
            relatives = relatives
        )

        assertThat(connectionsResponse.groupAffiliation).isEqualTo(groupAffiliation)
        assertThat(connectionsResponse.relatives).isEqualTo(relatives)

    }
}