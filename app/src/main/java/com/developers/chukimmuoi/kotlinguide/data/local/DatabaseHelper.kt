package com.developers.chukimmuoi.kotlinguide.data.local

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.developers.chukimmuoi.kotlinguide.data.model.Ribot
import com.squareup.sqlbrite2.BriteDatabase
import com.squareup.sqlbrite2.SqlBrite
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : KotlinGuide
 * Created by chukimmuoi on 10/09/2017.
 */
@Singleton
class DatabaseHelper @Inject constructor(dbOpenHelper: DbOpenHelper) {

    private val mDB: BriteDatabase

    init {
        val briteBuilder = SqlBrite.Builder()
        mDB = briteBuilder.build().wrapDatabaseHelper(dbOpenHelper, Schedulers.trampoline())
    }

    fun setRibots(newRibot: Collection<Ribot>): Observable<Ribot> {
        return Observable.create({ subscriber ->
            if (subscriber.isDisposed) return@create
            val transaction = mDB.newTransaction()
            try {
                mDB.delete(Db.RibotProfileTable.TABLE_NAME, null)
                for (ribot in newRibot) {
                    val result = mDB.insert(Db.RibotProfileTable.TABLE_NAME,
                            Db.RibotProfileTable.toContentValues(ribot.profile),
                            SQLiteDatabase.CONFLICT_REPLACE)
                    if (result >= 0) subscriber.onNext(ribot)
                }
                transaction.markSuccessful()
                subscriber.onComplete()
            } finally {
                transaction.end()
            }
        })
    }

    val ribots: Observable<List<Ribot>>
        get() = mDB.createQuery(Db.RibotProfileTable.TABLE_NAME,
                "SELECT * FROM " + Db.RibotProfileTable.TABLE_NAME)
                .mapToList { cursor: Cursor -> Ribot(Db.RibotProfileTable.parseCursor(cursor)) }
}