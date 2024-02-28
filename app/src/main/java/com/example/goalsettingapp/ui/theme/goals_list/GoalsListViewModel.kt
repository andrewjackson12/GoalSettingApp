package com.example.goalsettingapp.ui.theme.goals_list

import androidx.lifecycle.ViewModel
import com.example.goalsettingapp.data.Goal
import com.example.goalsettingapp.data.GoalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject
import com.example.goalsettingapp.ui.theme.util.UiEvent
import kotlinx.coroutines.flow.receiveAsFlow


@HiltViewModel
class GoalsListViewModel @Inject constructor(
    private val repository: GoalRepository
): ViewModel() {

    //All goals
    val goals = repository.getGoals()

    //Channel for UI events, allows for asynchronous communication
    //Allows us to communicate UI Events within the application
    private val _uiEvent = Channel<UiEvent>()
    //Recieve the UI events as a Flow to process UI events
    val uiEvent = _uiEvent.receiveAsFlow()

    //var to hold our most recently deleted goal for undo purposes
    private var deletedGoal: Goal? = null


}