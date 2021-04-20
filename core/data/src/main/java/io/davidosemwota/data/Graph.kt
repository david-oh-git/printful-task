package io.davidosemwota.data

import android.content.Context
import androidx.room.Room
import io.davidosemwota.data.network.SuperheroApiFactory
import io.davidosemwota.data.source.DefaultRepository
import io.davidosemwota.data.source.SuperheroRepository
import io.davidosemwota.data.source.SuperheroSource
import io.davidosemwota.data.source.local.LocalSource
import io.davidosemwota.data.source.local.SuperheroDao
import io.davidosemwota.data.source.local.SuperheroDatabase
import io.davidosemwota.data.source.remote.RemoteSource

object Graph {

    @Volatile
    private var repository: SuperheroRepository? = null

    private fun provideRepository(context: Context): SuperheroRepository {
        synchronized(this) {
            if (repository == null) {
                repository = DefaultRepository(
                    remoteSource = provideRemoteSource(),
                    localSource = provideLocalSource(context)
                )
            }

        }

        return repository ?: DefaultRepository(
            remoteSource = provideRemoteSource(),
            localSource = provideLocalSource(context)
        )
    }


    private fun provideLocalSource(context: Context): SuperheroSource =
        LocalSource(
            superheroDao = provideSuperHeroDao(context)
        )

    private fun provideRemoteSource(): SuperheroSource =
        RemoteSource(
            SuperheroApiFactory.provideSuperheroApiService()
        )

    private fun provideSuperHeroDao(context: Context): SuperheroDao =
        Room.databaseBuilder(
            context.applicationContext,
            SuperheroDatabase::class.java,
            "superheroes.db"
        ).build().superheroDao()
}