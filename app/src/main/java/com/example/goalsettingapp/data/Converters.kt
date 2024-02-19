package com.example.goalsettingapp.data

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.Date
class Converters {
    @TypeConverter
    fun fromDate(value: String?): Date? {
        if (value == null) return null

        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return dateFormat.parse(value)
    }

    @TypeConverter
    fun dateToTimeStamp(date: Date?): String? {
        if (date == null) return null

        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

        return dateFormat.format(date)
    }
}