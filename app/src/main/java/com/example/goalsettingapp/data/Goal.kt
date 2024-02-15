package com.example.goalsettingapp.data

import androidx.room.Entity
import java.util.Date
import androidx.room.PrimaryKey


@Entity
data class Goal (
    private val title: String,
    private val description: String,

    //ToDo: come back to see if making date nullable is valid for when the user chooses a date or continuous goal
    private val dateDue: Date?,

    //ToDo: Not sure if checkInFreq should be a string, could also be an int id sort of thing
    private val checkInFreq: String,

    //Primary key id generated automatically by room
    @PrimaryKey val id: Int? = null
) {




}