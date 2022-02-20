package org.techtown.navigation_test.model.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class NoteDataTable(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "contents") var contents: String,
    @ColumnInfo(name = "count") var count: Int
){
    constructor() : this(0, "", 0) // default 값
}

