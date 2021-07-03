package io.davidosemwota.data.source

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "superheroes"
)
data class Superhero(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val alterEgos: String,
    @ColumnInfo val firstAppearance: String,
    @ColumnInfo val publisher: String,
    @ColumnInfo val groupAffiliation: String,
    @ColumnInfo val imageUrl: String
)