package com.ibrajix.c2c.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ibrajix.c2c.BuildConfig
import com.ibrajix.c2c.network.ExhibitsLoader
import com.ibrajix.c2c.utils.EndPoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun providesGson(): Gson = GsonBuilder().setLenient().create()


    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson) : Retrofit {
        return Retrofit.Builder()
            .client(
                OkHttpClient.Builder().also { client ->
                    val logging = HttpLoggingInterceptor()
                    logging.level = HttpLoggingInterceptor.Level.BODY
                    if (BuildConfig.DEBUG) {
                        logging.level = HttpLoggingInterceptor.Level.BODY
                    }
                    client.addInterceptor(logging)
                }.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(EndPoints.BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ExhibitsLoader = retrofit.create(
        ExhibitsLoader::class.java)

}