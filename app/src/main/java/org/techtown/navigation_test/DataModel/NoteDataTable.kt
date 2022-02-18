package org.techtown.navigation_test.DataModel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notedatatable")
data class NoteDataTable(
    @PrimaryKey(autoGenerate = true) var id: Int?,
    @ColumnInfo(name = "contents") var contents: String,
    @ColumnInfo(name = "count") var count: Int
)

