package io.davidosemwota.data.network.services

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import io.davidosemwota.data.util.getJson
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.Rule
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

class SuperheroApiServiceTest {

    object MockResponses {
        const val listOfSuperheros = "mock-responses/get-superheros-status200.json"
    }

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var service: SuperheroApiService
    private lateinit var mockWebServer: MockWebServer

    @BeforeEach
    fun initialise() {
        mockWebServer = MockWebServer()
        mockWebServer.start()

        service = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SuperheroApiService::class.java)
    }

    @AfterEach
    fun reset() {
        mockWebServer.shutdown()
    }

    @Test
    fun requestSuperheros() = runBlocking {
        val expectedRequestUrl = '/' + SuperheroApiService.SUPERHERO_ENDPOINT
        val HTTP_REQUEST = "GET"
        mockWebServer.dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(getJson(MockResponses.listOfSuperheros))
            }
        }

        service.getSuperheros()
        val request = mockWebServer.takeRequest()
        assertThat(request.path).isEqualTo(expectedRequestUrl)
        assertThat(request.method).isEqualTo(HTTP_REQUEST)
    }
}