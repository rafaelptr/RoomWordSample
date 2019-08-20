package dev.petronilio.roomwordsample.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import dev.petronilio.roomwordsample.dao.WordDao
import dev.petronilio.roomwordsample.model.Word

class WordRepository(private val wordDao: WordDao) {

    val allWords: LiveData<List<Word>> = wordDao.getAllWords()

    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}