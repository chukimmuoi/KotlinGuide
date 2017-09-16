package com.developers.chukimmuoi.kotlinguide.data.remote

import com.developers.chukimmuoi.kotlinguide.data.model.Ribot
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : KotlinGuide
 * Created by chukimmuoi on 10/09/2017.
 */
interface RibotsService {

    @GET("ribots")
    fun getRibots() : Observable<List<Ribot>>

    companion object Creator {
        private val ENDPOINT = "https://api.ribot.io/"

        fun newRibotsService(): RibotsService {

            val gson = GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .create()

            val retrofit = Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

            return retrofit.create(RibotsService::class.java)
        }
    }
}