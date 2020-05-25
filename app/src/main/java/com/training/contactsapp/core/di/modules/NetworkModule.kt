package com.training.contactsapp.core.di.modules


import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.training.contactsapp.BuildConfig
import com.training.contactsapp.list.repository.ContactsRepositoryContract
import com.training.contactsapp.list.repository.ContactsRepositoryProvider
import com.training.contactsapp.list.repository.disk.AppDatabase
import com.training.contactsapp.list.repository.disk.ContactsDao
import com.training.contactsapp.list.repository.network.ContactApi
import com.training.contactsapp.list.repository.network.ContactsNetworkDataSource
import com.training.contactsapp.list.repository.network.ContactsRetrofitDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [NetworkModule.Declarations::class])
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder()
            .connectTimeout(CONNECTION_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
            .readTimeout(CONNECTION_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
            .writeTimeout(CONNECTION_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .addInterceptor(StethoInterceptor())
            .build()

    @Provides
    @Singleton
    fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }

    @Provides
    @Singleton
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(gsonConverterFactory)
        .baseUrl(SERVICE_BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideConverterFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)


    @Provides
    fun provideService(retrofit: Retrofit): ContactApi {
        return retrofit.create(ContactApi::class.java)
    }

    @Module
    internal interface Declarations {

        @Binds
        fun provideContactsNetworkDataSource(dataSource: ContactsRetrofitDataSource): ContactsNetworkDataSource

    }

    companion object {
        const val CONNECTION_TIMEOUT_SECONDS = 30
        const val SERVICE_BASE_URL = "https://randomuser.me/"
    }

}
