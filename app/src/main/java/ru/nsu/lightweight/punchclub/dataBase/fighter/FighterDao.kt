package ru.nsu.lightweight.punchclub.dataBase.fighter

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.nsu.lightweight.punchclub.dataBase.BaseDao

@Dao
abstract class FighterDao : BaseDao<Fighter>() {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(fighters: List<Fighter>)

    @Query("select * from fighter_table")
    abstract fun getAll(): List<Fighter>

    @Query("select * from fighter_table where id = :id")
    abstract fun getFighterById(id: Long): List<Fighter>
}