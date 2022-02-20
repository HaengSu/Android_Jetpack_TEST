package org.techtown.navigation_test.model.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope

@Database(entities = arrayOf(NoteDataTable::class), version = 1,exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun NoteDao() : NoteDao

    //싱글톤 사용을 위해서 companion object를 사용
    companion object {
        private var INSTANCE : NoteDatabase? = null

        //싱글톤 반환 메서드
        fun getDatabase(context: Context): NoteDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext, NoteDatabase::class.java,"note-db").build()
                INSTANCE = instance
                instance
            }
        }

    }


}