package com.example.exercicio.repository

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.exercicio.model.CalendarBO
import com.example.exercicio.model.UserBO

class TextRepository(context: Context, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_USER_TABLE = ("CREATE TABLE " + TABLE_USER + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_EMAIL + " TEXT,"
                + COLUMN_PASSWORD + " TEXT" + ")")
        db?.execSQL(CREATE_USER_TABLE)

        val CREATE_CALENDAR_TABLE = ("CREATE TABLE " + TABLE_TEXT + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_TEXT + " TEXT,"
                + COLUMN_ID_USER + " INTEGER,"
                + "FOREIGN KEY (" + COLUMN_ID_USER + ") REFERENCES " + TABLE_USER + "(" + COLUMN_ID + ")" + ")")
        db?.execSQL(CREATE_CALENDAR_TABLE)

        val values = ContentValues()
        values.put(COLUMN_ID, 1)
        values.put(COLUMN_EMAIL, "matheusfk74@gmail.com")
        values.put(COLUMN_PASSWORD, "130697")

        db?.insert(TABLE_USER, null, values)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CALENDAR)
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

    fun addCalendar(calendar: CalendarBO) {
        val values = ContentValues()
        values.put(COLUMN_CALENDAR, calendar.calendar)
        values.put(COLUMN_ID_USER, calendar.id_user)

        val db = this.writableDatabase

        db.insert(TABLE_CALENDAR, null, values)
        db.close()
    }

    fun findLastCalendar(): CalendarBO? {
        val query = "SELECT * FROM $TABLE_CALENDAR ORDER BY $COLUMN_ID DESC LIMIT 1"

        val db = this.writableDatabase

        val cursor = db.rawQuery(query, null)

        var findedCalendar: CalendarBO? = null

        if(cursor.moveToFirst()) {
            cursor.moveToFirst()

            val id = Integer.parseInt(cursor.getString(0))
            val calendar = cursor.getString(1)
            val id_user = Integer.parseInt(cursor.getString(2))

            findedCalendar = CalendarBO(id, calendar, id_user)
            cursor.close()
        }

        db.close()
        return findedCalendar
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

    fun findUserByEmail(email: String): UserBO? {
        val query = "SELECT * FROM $TABLE_USER WHERE $COLUMN_EMAIL = \"${email}\""

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
        val TABLE_TEXT = "text"
        val TABLE_CALENDAR = "calendar"

        val COLUMN_ID = "_id"
        val COLUMN_EMAIL = "email"
        val COLUMN_TEXT = "email"
        val COLUMN_PASSWORD = "password"
        val COLUMN_CALENDAR = "calendar"
        val COLUMN_ID_USER = "id_user"

    }

}