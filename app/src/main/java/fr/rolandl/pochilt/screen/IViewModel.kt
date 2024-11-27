package fr.rolandl.pochilt.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class IViewModel(
  private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) :
  ViewModel() {
  
  val error = MutableStateFlow<Boolean>(false)
  
  
  init {
    doingStuff()
  }
  
  private fun doingStuff() {
    viewModelScope.launch(dispatcher + CoroutineExceptionHandler { _, _ ->
      error.value = true
    }) {
      doingAnotherStuff()
    }
  }
  
  protected open fun doingAnotherStuff() {
  
  }
  
}