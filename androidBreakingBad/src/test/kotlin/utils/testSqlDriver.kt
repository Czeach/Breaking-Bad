package utils

import com.czech.breakingbad.datasource.cache.BreakingBadDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver

fun testSqlDriver(): SqlDriver {

    return JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY).apply {
        BreakingBadDatabase.Schema.create(this)
    }
}