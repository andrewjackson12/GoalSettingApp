package com.example.goalsettingapp.data

import androidx.room.Entity
import java.util.Date
import androidx.room.PrimaryKey


@Entity
data class Goal (
    val title: String,
    val description: String,

    //ToDo: Not sure if Date object is the best here, will have to see
    //Using type converter since Room can't save Date objects
    val dateDue: Date?,

    //ToDo: Not sure if checkInFreq should be a string, could also be an int id sort of thing
    val checkInFreq: String,

    //Primary key id generated automatically by room
    @PrimaryKey val id: Int? = null
) {




}