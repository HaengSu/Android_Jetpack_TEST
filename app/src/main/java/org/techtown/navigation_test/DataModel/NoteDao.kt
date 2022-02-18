package org.techtown.navigation_test.DataModel

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
    //onConflict 는 충돌전략으로(이미 목록에 있는 데이터와 중복될 경우 어떻게 처리할 것인지 정할 수 있다.)
    //suspend는 정지함수로 선언되어 background에서 작동되도록 함.(= 여기서 suspend 속성을 주어 반드시 코루틴 스코프 내에서 호출 되도록 강제해준다.)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(datatable : NoteDataTable )

    @Delete
    suspend fun delete(dataTable : NoteDataTable)

    //Livedata 를 사용 가능하게 함.
    @Query("SELECT * FROM NoteDataTable")
    fun getAll() : LiveData<List<NoteDataTable>>
}