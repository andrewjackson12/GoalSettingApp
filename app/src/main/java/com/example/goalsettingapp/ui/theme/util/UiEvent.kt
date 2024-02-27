package com.example.goalsettingapp.ui.theme.util


//Class to define different UiEvents
sealed class UiEvent {
    //Back stack holds various fragments (state of the application)
    //Popping removes current fragment ie pressing back and going back to the previous fragment
    object PopBackStack: UiEvent()
    //Navigates to specified route
    data class Navigate(val route: String): UiEvent()

    //Snackbar event, action is optional but there will always be a message
    //Snackbar will be displayed when a goal is deleted, giving option to undo deletion
    data class ShowSnackBar(
        val message: String,
        val action: String? = null
    ): UiEvent()
}