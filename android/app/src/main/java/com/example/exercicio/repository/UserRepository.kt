package com.example.exercicio.repository

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.Context
import android.content.ContentValues
import com.example.exercicio.model.UserBO

class UserRepository(context: Context, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_USER_TABLE = ("CREATE TABLE " + TABLE_USER + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_EMAIL + " TEXT,"
                + COLUMN_PASSWORD + " TEXT" + ")")
        db?.execSQL(CREATE_USER_TABLE)

        val values = ContentValues()
        values.put(COLUMN_ID, 1)
        values.put(COLUMN_EMAIL, "matheusfk74@gmail.com")
        values.put(COLUMN_PASSWORD, "130697")

        db?.insert(TABLE_USER, null, values)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER)
        onCreate(db)

    }

    fun addUser(user: UserBO) {
        val values = ContentValues()
        values.put(COLUMN_EMAIL, user.email)
        values.put(COLUMN_PASSWORD, user.password)

        val db = this.writableDatabase

        db.insert(TABLE_USER, null, values)
        db.close()
    }

    fun findUser(user: UserBO): UserBO? {
        val query = "SELECT * FROM $TABLE_USER WHERE $COLUMN_EMAIL = \"${user.email}\"" +
                " AND  $COLUMN_PASSWORD = \"${user.password}\""

        val db = this.writableDatabase

        val cursor = db.rawQuery(query, null)

        var findedUser: UserBO? = null

        if(cursor.moveToFirst()) {
            cursor.moveToFirst()

            val id = Integer.parseInt(cursor.getString(0))
            val email = cursor.getString(1)
            val password = cursor.getString(2)

            findedUser = UserBO(id, email, password)
            cursor.close()
        }

        db.close()
        return findedUser
    }

    companion object {

        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "userDB.db"
        val TABLE_USER = "user"

        val COLUMN_ID = "_id"
        val COLUMN_EMAIL = "email"
        val COLUMN_PASSWORD = "password"
    }

}