package org.techtown.navigation_test.repository

import androidx.lifecycle.LiveData
import org.techtown.navigation_test.DataModel.NoteDao
import org.techtown.navigation_test.DataModel.NoteDataTable

class NoteRepository(private var notedao : NoteDao) {

    val readAllData : LiveData<List<NoteDataTable>> = notedao.getAll()

    suspend fun insert(datatable : NoteDataTable) {
        NoteDao.insert(datatable)
    }
}