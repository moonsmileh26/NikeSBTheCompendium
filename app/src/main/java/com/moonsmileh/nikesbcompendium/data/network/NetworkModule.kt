package com.moonsmileh.nikesbcompendium.data.network

import com.moonsmileh.nikesbcompendium.data.NikeSBRepositoryImpl
import com.moonsmileh.nikesbcompendium.domain.NikeSBRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.3.71:3000/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    fun providesNikeSBApiService(retrofit: Retrofit): NikeSBApiService {
        return retrofit.create(
            NikeSBApiService::
            class.java
        )
    }

    @Provides
    fun providesRepository(apiService: NikeSBApiService)
            : NikeSBRepository {
        return NikeSBRepositoryImpl(apiService)
    }

}