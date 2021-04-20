package io.davidosemwota.data.source.local

import android.content.Context
import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import io.davidosemwota.data.source.Superhero
import io.davidosemwota.data.util.MainCoroutineRule
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
internal class SuperheroDaoTest {

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var database: SuperheroDatabase
    private lateinit var superheroDao: SuperheroDao

    @Before
    fun initialise() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(
            context.applicationContext,
            SuperheroDatabase::class.java
        ).allowMainThreadQueries()
            .build()

        superheroDao = database.superheroDao()
    }

    @After
    fun reset() {
        database.close()
    }

    @Test
    fun `Save a superhero , confirm it is saved to database`() = runBlockingTest {
        // Arrange: save a superhero
        val expectedSuperhero = Superhero(
            name = "Super Agbakpan",
            id = 73,
            groupAffiliation = "The Shagewells Nigerian union of teachers",
            publisher = "Okodo comics",
            firstAppearance = "Captain Afrika Issue 218",
            alterEgos = "Dele Badore",
            imageUrl = "http://cat.jpg"
        )

        superheroDao.save(expectedSuperhero)

        // Act: Get only item from database
        val superhero = superheroDao.getSuperheroes().take(1).toList()[0][0]

        //Assert: confirm results

        assertThat(superhero.alterEgos).isEqualTo(expectedSuperhero.alterEgos)
        assertThat(superhero.firstAppearance).isEqualTo(expectedSuperhero.firstAppearance)
        assertThat(superhero.id).isEqualTo(expectedSuperhero.id)
        assertThat(superhero.publisher).isEqualTo(expectedSuperhero.publisher)
        assertThat(superhero.name).isEqualTo(expectedSuperhero.name)
        assertThat(superhero.imageUrl).isEqualTo(expectedSuperhero.imageUrl)
    }
}