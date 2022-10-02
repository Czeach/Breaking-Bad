package utils

import com.czech.breakingbad.datasource.cache.BreakingBadDatabase
import com.czech.breakingbad.datasource.cache.Characters_Entity
import com.czech.breakingbad.util.SQLDelightConverters
import com.squareup.sqldelight.ColumnAdapter
import org.mockito.Mock

@Mock
private lateinit var dbStringConverter: ColumnAdapter<List<String>, String>

@Mock
private lateinit var dbIntConverter: ColumnAdapter<List<Int>, String>

fun testDatabase(): BreakingBadDatabase {
    val driver = testSqlDriver()

    dbStringConverter = SQLDelightConverters.listOfStringsAdapter
    dbIntConverter = SQLDelightConverters.listOfIntsAdapter

    return BreakingBadDatabase(driver, Characters_Entity.Adapter(
        dbStringConverter,
        dbIntConverter,
        dbIntConverter
    ))
}