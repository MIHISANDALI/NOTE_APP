package com.example.notessqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class NotesDatabaseHelper (context:Context): SQLiteDpenHelper(context, DATABASE_NAME,null,
    DATABASE_VERSION){

    companion object {
        private const val DATABASE_NAME = "notesapp.db"
        private const val DATABASE_VERSION = "1"
        private const val TABLE_NAME = "allnotes"
        private const val COLUMN_ID = "id"
        private const val COLUMN_TITLE = "title"
        private const val COLUMN_CONTENT = "content"
    }

    fun onCreate(p0:SQLiteDatabase?){
        val createTableQuery="CREATE TABLE $TABLE_NAME($COLUMN_ID INTEGER PRIMARY KEY,$COLUMN_TITLE TEXT,$COLUMN_CONTENT TEXT)"
        val db
        db?.execSQL(createTableQuery)
    }
    fun onUpgrade(p0:SQLiteDatabase?){
        val dropTableQuery="DROP TABLE IFEXISTS $TABLE_NAME"
        val db
        db?.execSQL(dropTableQuery)
            onCreate(db)
    }
    fun insertNote(note:Note){
        val db=writableDatabase
        val values=contentValues().apply{
            put(COLUMN_TITLE,note.title)
            put(COLUMN_CONTENT,note.content)
        }
        db.insert(TABLE_NAME,null,values)
        db.close()
    }

    private fun contentValues() {

    }

    private fun put(columnContent: String, content: String) {

    }

    fun getAllNotes(): List<Note> {

        return TODO("Provide the return value")
    }

    fun getNoteByID(noteId: Int) {

    }


}

open class SQLiteDpenHelper(context: Context, databaseName: String, nothing: Nothing?, databaseVersion: String) {

}
fun getAllNotes():List<Note> {
    val notesList = mutableListOf<Note>()
    val db = radableDatabase
    val query = "SELECT*FROM $TABLENAME"
    val cursor = db.rawQuery(query, null)

    while (cursor.moveToNext()) {
        val id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
        val title=cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE))
        val content = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ CONENT))

        val note=Note(id,title,content)
        notesList.add(note)

        cursor.close()
        db.close()
        return notesList
    }
     fun updateNote(note:Note){
         val db =writableDatabase
         val values=ContentValues().apply{
             put(COLUMN_TITLE,note.title)
             put(COLUMN_CONTENT,note.content)
         }
         val whereClause ="$COLUMN_ID=?"
         val whereArgs =arrayOf(note.id.toString())
         db.update(TABLE_NAME,values,whereClause,whereArgs)
         db.close()

         fun getNoteByID(noteId:Int):Note {

             val db = radableDatabase
             val query = "SELECT*FROM $TABLENAME where $COLUMN_ID=$noteId"
             val cursor = db.rawQuery(query, null)
             cursor.moveToFirst()

                 val id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
                 val title=cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE))
                 val content = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ CONENT))

                 val note=Note(id,title,content)
                 notesList.add(note)

                 cursor.close()
                 db.close()
                 return Note(id,title,content)
             }
         fun deleteNote(noteId:Int){
             val db=writableDatabase
             val whereClause="COLUMN_ID=?"
             val whereArgs=arrayof(noteId,toString())
             db.delete(TABLE_NAME,whereClause,whereArgs)
             db.close()
         }
     }

}

