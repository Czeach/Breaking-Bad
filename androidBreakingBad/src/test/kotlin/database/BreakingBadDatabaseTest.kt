package database

import com.czech.breakingbad.datasource.cache.BreakingBadDBQueries
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import utils.testDatabase

class BreakingBadDatabaseTest {

    @Mock
    private lateinit var queries: BreakingBadDBQueries

    @Before
    fun setUp() {
        val database = testDatabase()
        queries = database.breakingBadDBQueries
    }

    @Test
    fun insertAndRead() {

        queries.insertCharacter(
            char_id = 1L,
            name = "",
            birthday = "",
            occupation = listOf("", "", ""),
            img = "",
            status = "",
            nickname = "",
            appearance = listOf(1, 4, 2),
            portrayed = "",
            category = "",
            better_call_saul_appearance = listOf(6, 9)
        )

        queries.insertCharacter(
            char_id = 3L,
            name = "",
            birthday = "",
            occupation = listOf("", "", ""),
            img = "",
            status = "",
            nickname = "",
            appearance = listOf(1, 4, 2),
            portrayed = "",
            category = "",
            better_call_saul_appearance = listOf(6, 9)
        )

        Assert.assertEquals(2, queries.getAllCharacters().executeAsList().size)
    }

    @Test
    fun getCharById() {

        val id = 8L

        queries.insertCharacter(
            char_id = id,
            name = "",
            birthday = "",
            occupation = listOf("", "", ""),
            img = "",
            status = "",
            nickname = "",
            appearance = listOf(1, 4, 2),
            portrayed = "",
            category = "",
            better_call_saul_appearance = listOf(6, 9)
        )

        Assert.assertEquals(1, queries.getcharacterById(id).executeAsList().size)

    }


}