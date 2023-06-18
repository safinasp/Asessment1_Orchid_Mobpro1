package org.d3if3030.anggrek.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if3030.anggrek.model.Orchid
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/safinasp/json-orchid/main/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface OrchidApiService{
    @GET("orchid.json")
    suspend fun getOrchid(): List<Orchid>
}

object OrchidApi{
    val service: OrchidApiService by lazy {
        retrofit.create(OrchidApiService::class.java)
    }
    fun getOrchidUrl(gambar: String): String {
        return "$BASE_URL$gambar"
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }