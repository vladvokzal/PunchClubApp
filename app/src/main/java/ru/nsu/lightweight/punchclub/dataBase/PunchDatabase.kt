package ru.nsu.lightweight.punchclub.dataBase

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.nsu.lightweight.punchclub.ProjectApplication
import ru.nsu.lightweight.punchclub.dataBase.fighter.Fighter
import ru.nsu.lightweight.punchclub.dataBase.fighter.FighterDao
import ru.nsu.lightweight.punchclub.dataBase.fighter.FighterRepository

@Database(
    entities = [Fighter::class],
    version = 1
)
abstract class PunchDatabase : RoomDatabase() {

    abstract fun fighterDao(): FighterDao

    val figterRepository by lazy {
        FighterRepository(fighterDao())
    }

    companion object {

        @Volatile
        private var INSTANCE: PunchDatabase? = null

        fun getDatabase(): PunchDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    ProjectApplication.applicationInstance,
                    PunchDatabase::class.java,
                    "estate_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}