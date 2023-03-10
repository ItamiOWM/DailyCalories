package com.example.dailycalories.di

import android.app.Application
import androidx.room.Room
import com.example.dailycalories.data.local.room.DailyCaloriesDatabase
import com.example.dailycalories.data.local.room.dao.MealDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Singleton
    @Provides
    fun provideMealDao(
        db: DailyCaloriesDatabase
    ): MealDao = db.mealDao()


    @Singleton
    @Provides
    fun provideDatabase(
        application: Application,
    ): DailyCaloriesDatabase {
        return Room.databaseBuilder(
            application,
            DailyCaloriesDatabase::class.java,
            DailyCaloriesDatabase.DB_NAME
        ).build()
    }

}