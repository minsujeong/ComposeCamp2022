package com.codelabs.basicstatecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel(){
    private val _tasks = getWellnessTask().toMutableStateList()
    val tasks : List<WellnessTask>
        get() = _tasks

    fun remove(item : WellnessTask) {
        _tasks.remove(item)
    }

    fun changeTaskChecked(item : WellnessTask, checked : Boolean) =
        tasks.find { it.id == item.id }?.let { task ->
            task.checked.value = checked
        }
}

private fun getWellnessTask() = List(30) {
    WellnessTask(it, "Task # $it")
}