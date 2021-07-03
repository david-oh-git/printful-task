package io.davidosemwota.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import io.davidosemwota.data.source.Superhero

@Database(
    entities = [Superhero::class],
    version = 1,
    exportSchema = false
)
abstract class SuperheroDatabase : RoomDatabase() {

    abstract fun superheroDao(): SuperheroDao
}