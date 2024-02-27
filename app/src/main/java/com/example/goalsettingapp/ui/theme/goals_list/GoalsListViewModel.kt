package com.example.goalsettingapp.ui.theme.goals_list

import androidx.lifecycle.ViewModel
import com.example.goalsettingapp.data.GoalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject
import com.example.goalsettingapp.ui.theme.util.UiEvent


@HiltViewModel
class GoalsListViewModel @Inject constructor(
    private val repository: GoalRepository
): ViewModel() {

    //All goals
    val goals = repository.getGoals()

    private val _uiEvent = Channel<UiEvent>()
}