package ru.myitacademy.composedemo.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import ru.myitacademy.composedemo.data.Record

class MainViewModel: ViewModel() {

    var recordsState by mutableStateOf(
        listOf(
            Record(
                heading = "Wake up, samurai",
                subtext = "We've got a city to burn"
            ),
            Record(
                heading = "Wake up, samurai",
                subtext = "We've got a city to burn"
            ),
            Record(
                heading = "Wake up, samurai",
                subtext = "We've got a city to burn"
            ),
            Record(
                heading = "Rudimentary creatures of blood and flesh",
                subtext = "You touch my mind, fumbling in ignorance. Incapable of understanding."
            )
        )
    )
        private set

    fun addRecord(record: Record) {
        recordsState = recordsState + listOf(record)
    }
}