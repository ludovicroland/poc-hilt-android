package fr.rolandl.pochilt.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import fr.rolandl.pochilt.model.Post

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
  modifier: Modifier = Modifier,
  viewModel: HomeViewModel = hiltViewModel()
) {
  Scaffold(
    modifier = modifier,
    topBar = {
      TopAppBar(
        title = {
          Text("Hello")
        }
      )
    }
  ) { contentPadding ->
    val posts by viewModel.posts.collectAsStateWithLifecycle()
    val error by viewModel.error.collectAsStateWithLifecycle()
    
    if(error == true) {
      Text("Error")
    }
    else {
      HomefeedList(
        modifier = modifier.padding(contentPadding),
        posts = posts
      )
    }
  }
}

@Composable
private fun HomefeedList(
  modifier: Modifier = Modifier,
  posts: List<Post>
) {
  LazyColumn(
    modifier = modifier.padding(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp),
  ) {
    items(posts) { post ->
      HomefeedCell(
        post = post
      )
    }
  }
}

@Composable
private fun HomefeedCell(
  post: Post
) {
  ElevatedCard(
    modifier = Modifier.fillMaxWidth(),
  ) {
    Column(
      modifier = Modifier.padding(8.dp),
    ) {
      Text(
        text = post.title,
        style = MaterialTheme.typography.titleLarge
      )
      if (post.description.isNullOrEmpty() == false) {
        Text(
          text = post.description,
          style = MaterialTheme.typography.bodyMedium
        )
      }
    }
  }
}