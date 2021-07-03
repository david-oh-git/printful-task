package io.davidosemwota.data.network.responses

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test


internal class ImagesResponseTest {

    @Test
    fun createImageResponse_getCorrectAttributes() {

        val xs = "http://thebooks.com/titles/The_grrim_xs.jpg"
        val lg = "http://thebooks.com/titles/The_grrim_lg.jpg"
        val md = "http://thebooks.com/titles/The_grrim_md.jpg"
        val sm = "http://thebooks.com/titles/The_grrim_sm.jpg"

        val imagesResponse = ImagesResponse(
                xs = xs,
                lg = lg,
                md = md,
                sm = sm
        )

        assertThat(imagesResponse.lg).isEqualTo(lg)
        assertThat(imagesResponse.xs).isEqualTo(xs)
        assertThat(imagesResponse.md).isEqualTo(md)
        assertThat(imagesResponse.sm).isEqualTo(sm)
    }
}