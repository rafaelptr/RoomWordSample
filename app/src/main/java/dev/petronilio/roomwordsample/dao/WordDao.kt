package dev.petronilio.roomwordsample.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.petronilio.roomwordsample.model.Word

@Dao
interface WordDao {

    /*@Query("SELECT * from word_table ORDER BY word ASC")
    fun getAllWords(): List<Word>*/

    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAllWords(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    fun deleteAll()
}