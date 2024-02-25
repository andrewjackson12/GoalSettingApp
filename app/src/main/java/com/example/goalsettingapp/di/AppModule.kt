package com.example.goalsettingapp.di

import android.app.Application
import androidx.room.Room
import com.example.goalsettingapp.data.GoalDatabase
import com.example.goalsettingapp.data.GoalRepository
import com.example.goalsettingapp.data.GoalRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


//Dependency injection for creating and accessing the database


//Dagger Hilt Module - provides dependencies to other parts of the app
@Module
//Giving dependencies a singleton scope (one instance)
@InstallIn(SingletonComponent::class)
object AppModule {
    //Provides annotation indicates that the method provides dependencies
    @Provides
    @Singleton
    //Function to build database
    fun providesGoalDatabase(app: Application) : GoalDatabase {
        return Room.databaseBuilder(
            app,
            GoalDatabase::class.java,
            "goal_db"
        ).build()

    }


    //Provides an instance of GoalRepo - creates a repo implementation passing the DAO to the repo implementation
    @Provides
    @Singleton
    fun provideGoalRepository(db: GoalDatabase): GoalRepository {
        //May need to look into this, not sure if dao function will work
        return GoalRepositoryImpl(db.dao())
    }


}