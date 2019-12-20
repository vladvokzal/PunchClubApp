package ru.nsu.lightweight.punchclub.dataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

@Dao
abstract class BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(entity: T)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun update(entity: T)

    @Delete
    abstract fun delete(entity: T)
}