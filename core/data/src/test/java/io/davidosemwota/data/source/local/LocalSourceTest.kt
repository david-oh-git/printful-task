package io.davidosemwota.data.source.local

import com.google.common.truth.Truth.assertThat
import io.davidosemwota.data.source.Superhero
import io.davidosemwota.data.source.SuperheroSource
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.slot
import io.mockk.verify
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class LocalSourceTest {

    @MockK(relaxed = true)
    private lateinit var superheroDao: SuperheroDao
    private lateinit var ioDispatcher: CoroutineDispatcher
    private lateinit var localSource: SuperheroSource

    @BeforeEach
    fun initialise() {
        MockKAnnotations.init(this)
        ioDispatcher = Dispatchers.Unconfined

        localSource = LocalSource(
                ioDispatcher = ioDispatcher,
                superheroDao = superheroDao
        )
    }

    @Test
    fun `get all superheros should invoke dao getSuperhero method`() = runBlockingTest {
        localSource.getSuperheros()

        verify { superheroDao.getSuperheroes() }
    }

    @Test
    fun `Delete all superheros should invoke dao emptyDatabase method`() = runBlockingTest {
        localSource.deleteDatabase()

        coVerify { superheroDao.emptyDatabase() }
    }

    @Test
    fun`Save Superhero object should invoke dao save method`() = runBlockingTest {
        val superhero = Superhero(
                name = "Spider Man",
                alterEgos = "Peter Parker",
                firstAppearance = "",
                publisher = "Marvel Comics",
                groupAffiliation = "",
                imageUrl = "",
                id = 23
        )

        localSource.save(superhero)

        val superheroSlot = slot<Superhero>()
        coVerify { superheroDao.save( capture(superheroSlot)) }

        assertThat(superhero).isEqualTo(superheroSlot.captured)
    }

    @Test
    fun `Find superhero item should invoke dao's finf method`() = runBlockingTest {
        val id = 91
        localSource.find(id)

        val idSlot = slot<Int>()
        coVerify { superheroDao.find( capture(idSlot)) }

        assertThat(id).isEqualTo(idSlot.captured)
    }

}