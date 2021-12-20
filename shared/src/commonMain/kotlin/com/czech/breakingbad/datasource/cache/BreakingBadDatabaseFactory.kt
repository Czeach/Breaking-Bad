package com.czech.breakingbad.datasource.cache

import com.czech.breakingbad.util.SQLDelightConverters
import com.squareup.sqldelight.db.SqlDriver

class BreakingBadDatabaseFactory(private val driverFactory: DriverFactory) {

    fun createDatabase(): BreakingBadDatabase {
        return BreakingBadDatabase(driver = driverFactory.createDriver(), characters_EntityAdapter = Characters_Entity.Adapter(
            occupationAdapter = SQLDelightConverters.listOfStringsAdapter,
            appearanceAdapter = SQLDelightConverters.listOfIntsAdapter,
            better_call_saul_appearanceAdapter = SQLDelightConverters.listOfIntsAdapter
        ))
    }
}

expect class DriverFactory {
    fun createDriver(): SqlDriver
}