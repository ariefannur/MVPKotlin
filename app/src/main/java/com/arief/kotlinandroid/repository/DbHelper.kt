package com.arief.kotlinandroid.repository

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.arief.kotlinandroid.model.Todo
import java.util.*

/**All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Originally written by Author Name Arief Maffrudin A N, 06/04/17
 */
class DbHelper : SQLiteOpenHelper {
    constructor(context: Context) : super(context, "DB", null, 1)

    val TB_TODO : String = "tb_todo"
    val COL_ID : String = "id"
    val COL_TITLE : String = "title"
    val COL_DESC : String = "desc"
    val COL_DATE : String = "date"

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    override fun onCreate(db: SQLiteDatabase?) {
        var sql: String = "CREATE TABLE $TB_TODO ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COL_TITLE VARCHAR(30), $COL_DESC TEXT, $COL_DATE VARCHAR(10))"
        db?.execSQL(sql)
    }

    fun insertData(todo: Todo): Boolean{
        val db: SQLiteDatabase = this.writableDatabase

        var cv = ContentValues()
        cv.put(COL_TITLE, todo.mTitle)
        cv.put(COL_DESC, todo.mDesc)
        cv.put(COL_DATE, todo.mDate)
        return db.insert(TB_TODO, null, cv) > 0

    }

    fun getAllTodo(): List<Todo>{
        var lsTodos: MutableList<Todo> = ArrayList<Todo>()

        val db: SQLiteDatabase = this.readableDatabase
        val sql: String = "SELECT * FROM $TB_TODO"
        val cursor: Cursor = db.rawQuery(sql, null)
        if(cursor.moveToFirst()) {
            do {
            val todo: Todo = Todo(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3))
                lsTodos.add(todo)

            } while (cursor.moveToNext())
        }

        return lsTodos
    }

    fun updateData(todo: Todo): Boolean{
        val db: SQLiteDatabase = this.readableDatabase

        var cv = ContentValues()
        cv.put(COL_TITLE, todo.mTitle)
        cv.put(COL_DESC, todo.mDesc)
        cv.put(COL_DATE, todo.mDate)
        cv.put(COL_ID, todo.mId)
        val id = todo.mId
        return db.update(TB_TODO, cv, "$COL_ID = $id", null) > 0

    }

    fun deleteData(id: Int): Boolean{
        val db: SQLiteDatabase = this.readableDatabase

        return db.delete(TB_TODO, "$COL_ID = $id", null) > 0

    }

}