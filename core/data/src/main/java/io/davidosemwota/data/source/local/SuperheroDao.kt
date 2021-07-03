package io.davidosemwota.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.davidosemwota.data.source.Superhero
import kotlinx.coroutines.flow.Flow

/**
 * Data access object for [Superhero] entity.
 */
@Dao
interface SuperheroDao {

    @Query("SELECT * FROM superheroes ORDER BY id")
    fun getSuperheroes(): Flow<List<Superhero>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(superhero: Superhero)

    @Query("DELETE FROM superheroes")
    suspend fun emptyDatabase()

    @Query("SELECT * FROM superheroes WHERE id = :id")
    suspend fun find(id: Int): Superhero?
}