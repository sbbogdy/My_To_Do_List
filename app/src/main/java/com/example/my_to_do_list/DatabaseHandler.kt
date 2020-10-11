package com.example.my_to_do_list

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import androidx.core.content.contentValuesOf

val DATABASE_NAME = "DB"
val TABLE_NAME = "TASKS"
val COL_TASK = "task"
val COL_DESC = "description"
val COL_ID = "id"

class DatabaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME ,null,1)
{
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_TASK +" VARCHAR(256)," +
                COL_DESC +" VARCHAR(256))";

        db?.execSQL(createTable)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData (task: Task){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_TASK, task.task)
        cv.put(COL_DESC, task.description)
        var result = db.insert(TABLE_NAME, null, cv)
        if(result == -1.toLong())
            Toast.makeText(context, "Failed",Toast.LENGTH_LONG).show()
        else
            Toast.makeText(context, "Succes",Toast.LENGTH_LONG).show()
    }

    fun readData() : MutableList<Task>{
        var list : MutableList<Task> = ArrayList()

        val db = this.readableDatabase
        val query = "Select * from " + TABLE_NAME
        val result = db.rawQuery(query, null)
        if(result.moveToFirst()) {
            do{
                var task = Task()
                task.task = result.getString(result.getColumnIndex(COL_TASK))
                list.add(task)
            }while(result.moveToNext())
        }

        result.close()
        db.close()
        return list

    }

}