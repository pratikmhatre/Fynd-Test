package com.example.cavista_test.di.modules

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.cavista_test.data.DataManager
import com.example.cavista_test.data.DataManagerClass
import com.example.cavista_test.data.db.MyDatabase
import com.example.cavista_test.data.network.ApiList
import com.example.cavista_test.utils.AppConstants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer
import se.akerfeldt.okhttp.signpost.SigningInterceptor
import javax.inject.Singleton

@Module
class AppModule(val appContext: Context) {

    @Provides
    @Singleton
    fun provideSharedPrefs(): SharedPreferences {
        return appContext.getSharedPreferences("prefs", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideDatabase(): MyDatabase {
        return Room.databaseBuilder(appContext, MyDatabase::class.java, AppConstants.FEEDS_TABLE)
            .build()
    }

    @Singleton
    @Provides
    fun provideDataManager(dataManagerClass: DataManagerClass): DataManager {
        return dataManagerClass
    }
}