package com.biniyam.sqlitenote7423

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
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
    fun getAllNotes(): List<NoteModel> {
        val returnList = ArrayList<NoteModel>()
        val query = "SELECT * FROM $TABLE_NAME ORDERED BY $COL_TITLE DESC"

        val db = this.readableDatabase

        val result : Cursor = db.rawQuery(query, null)

        if (result.moveToFirst()) {
            do {
                val noteId = result.getInt(0)
                val noteTitle = result.getString(1)
                val noteDetails = result.getString(3)

                val note = NoteModel(noteId, noteTitle, noteDetails)
                returnList.add(note)

            } while (result.moveToNext())
        }
        result.close()
        db.close()

        return  returnList
    }

    fun deleteNote( note: NoteModel) :Boolean {
        val db = this.writableDatabase
        val query = "DELETE FROM $TABLE_NAME WHERE $COL_ID = ${note.id}"

        val cursor : Cursor = db.rawQuery(query, null)
        val result = cursor.moveToFirst()
        cursor.close()
        db.close()

        return  result
    }

}