package com.example.globallogicapp.di

import com.example.globallogicapp.data.network.ArticlesAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://private-f0eea-mobilegllatam.apiary-mock.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    fun provideArticleApi(retrofit: Retrofit): ArticlesAPI{
        return retrofit.create(ArticlesAPI::class.java)
    }
}