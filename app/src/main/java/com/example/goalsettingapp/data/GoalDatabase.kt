package com.example.goalsettingapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(
    entities = [Goal::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class GoalDatabase: RoomDatabase() {
    abstract fun dao(): GoalDao
}