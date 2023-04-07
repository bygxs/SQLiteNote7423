package com.biniyam.sqlitenote7423

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class NoteDao( context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {

    val TABLE_NAME = "notes"
    val COL_ID = "id"
    val COL_TITLE = "title"
    val COL_DETAIL = "detail"

    constructor(context: Context?) : this(context, "noteDB", null, 1 )

    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE notes ( $COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COL_TITLE TEXT, $COL_DETAIL INTEGER ) "


        db?.execSQL(query)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun addNote (note: NoteModel ): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put(COL_TITLE,note.title)
        cv.put(COL_DETAIL,note.detail)


        val result = db.insert(TABLE_NAME, null, cv)
        db.close()
        return result != -1L  //   i
//        // if (result == -1L)
//        return false
//        else return true


    }

}