package com.laam.moviedb_cleanarch.framework.data.network

import com.laam.moviedb_cleanarch.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object AppNetwork {

    fun createMovieNetwork(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { addApiQueryParam(it) }
            .build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.MOVIE_DB_URL)
            .client(okHttpClient)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                )
            )
            .build()
    }

    private fun addApiQueryParam(it: Interceptor.Chain): okhttp3.Response {
        var request = it.request()

        val url = request.url()
            .newBuilder()
            .addQueryParameter("api_key", BuildConfig.MOVIE_DB_KEY)
            .build()

        request = request.newBuilder()
            .url(url)
            .build()

        return it.proceed(request)
    }
}