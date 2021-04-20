package io.davidosemwota.data.network

import io.davidosemwota.data.BuildConfig
import io.davidosemwota.data.network.services.SuperheroApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SuperheroApiFactory {

    private const val baseUrl = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/"

    /**
     *  Provider method for [HttpLoggingInterceptor] for HTTP client
     *
     *  @return Instance of http interceptor
     */
    private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    /**
     *  Provides instance of [OkHttpClient]
     *
     *  @return Instance of http client
     */
    private fun provideHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            clientBuilder.addInterceptor(interceptor)
        }
        return clientBuilder.build()
    }

    /**
     * Provider method for [Retrofit]
     *
     * @return Instance of retrofit
     */
    private fun provideRetrofitBuilder() =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideHttpClient(provideHttpLoggingInterceptor()))
            .build()

    fun provideSuperheroApiService(): SuperheroApiService =
            provideRetrofitBuilder().create(SuperheroApiService::class.java)
}