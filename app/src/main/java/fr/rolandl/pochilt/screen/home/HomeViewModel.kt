package fr.rolandl.pochilt.screen.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.rolandl.pochilt.data.repository.PostRepository
import fr.rolandl.pochilt.model.Post
import fr.rolandl.pochilt.screen.IViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
  private val savedStateHandle: SavedStateHandle,
  postRepository: PostRepository
) :
  IViewModel() {
    
  private val id = savedStateHandle.get<Int>("id").also { println(it) }
  
  private val _posts: MutableStateFlow<List<Post>> = MutableStateFlow(emptyList())
  
  /**
   * Returns a Flow observable containing the list of posts fetched from the repository.
   *
   * @return A Flow<List<Post>> object that can be observed for changes.
   */
  val posts: StateFlow<List<Post>>
    get() = _posts
  
  override fun doingAnotherStuff() {
    savedStateHandle.get<Int>("id").also { println(it) }
  }
}