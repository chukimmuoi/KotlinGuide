package com.developers.chukimmuoi.kotlinguide.data.local

import android.content.ContentValues
import android.database.Cursor
import com.developers.chukimmuoi.kotlinguide.data.model.Name
import com.developers.chukimmuoi.kotlinguide.data.model.Profile
import java.util.*

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : KotlinGuide
 * Created by chukimmuoi on 10/09/2017.
 */
class Db {
    companion object RibotProfileTable {
        public val TABLE_NAME = "ribot_profile"

        private val COLUMN_EMAIL = "email"
        private val COLUMN_FIRST_NAME = "first_name"
        private val COLUMN_LAST_NAME = "last_name"
        private val COLUMN_HEX_COLOR = "hex_color"
        private val COLUMN_DATE_OF_BIRTH = "date_of_birth"
        private val COLUMN_AVATAR = "avatar"
        private val COLUMN_BIO = "bio"

        val CREATE = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_EMAIL + " TEXT PRIMARY KEY, " +
                COLUMN_FIRST_NAME + " TEXT NOT NULL, " +
                COLUMN_LAST_NAME + " TEXT NOT NULL, " +
                COLUMN_HEX_COLOR + " TEXT NOT NULL, " +
                COLUMN_DATE_OF_BIRTH + " INTEGER NOT NULL, " +
                COLUMN_AVATAR + " TEXT, " +
                COLUMN_BIO + " TEXT);"

        fun toContentValues(profile: Profile): ContentValues {
            val values = ContentValues()
            values.put(COLUMN_EMAIL, profile.email)
            values.put(COLUMN_FIRST_NAME, profile.name.first)
            values.put(COLUMN_LAST_NAME, profile.name.last)
            values.put(COLUMN_HEX_COLOR, profile.hexColor)
            values.put(COLUMN_DATE_OF_BIRTH, profile.dateOfBirth.time)
            values.put(COLUMN_AVATAR, profile.avatar)
            profile.bio?.let { values.put(COLUMN_BIO, profile.bio) }
            return values
        }

        fun parseCursor(cursor: Cursor): Profile {
            val name = Name(
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FIRST_NAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_LAST_NAME)))
            val dobTime = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_DATE_OF_BIRTH))

            return Profile(name,
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_HEX_COLOR)),
                    Date(dobTime),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_BIO)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_AVATAR)))
        }
    }
}