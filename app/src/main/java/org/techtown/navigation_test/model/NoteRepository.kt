package org.techtown.navigation_test.model

import android.app.Application
import androidx.annotation.WorkerThread
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import androidx.room.RoomDatabase
import org.techtown.navigation_test.model.roomdb.NoteDao
import org.techtown.navigation_test.model.roomdb.NoteDataTable
import org.techtown.navigation_test.model.roomdb.NoteDatabase

/**
 * Repository 에서 네트워크나 Dao 통신을 통한 데이터를 가져옵니다.
 * (= 간단하게 말하면 데이터를 요청하고 가져오는 Model 클래스라고 생각하시면 됩니다.)
 */
class NoteRepository() {
    private lateinit var noteDao : NoteDao
    private var getAllNote = noteDao.getAll()

    @WorkerThread
    suspend fun insert(noteDataTable: NoteDataTable){

    }
}



































