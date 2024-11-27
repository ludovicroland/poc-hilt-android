package fr.rolandl.pochilt.data.service

import fr.rolandl.pochilt.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * This class implements the PostApi interface and provides a fake in-memory data source for Posts.
 * It's intended for testing purposes and simulates a real API.
 */
class PostFakeApi : PostApi {
  
  private val posts = MutableStateFlow(
    mutableListOf(
      Post(
        "5",
        "The Secret of the Flowers",
        "Improve your goldfish's physical fitness by getting him a bicycle.",
        null,
        1629858873, // 25/08/2021
      ),
      Post(
        "4",
        "The Door's Game",
        null,
        "https://picsum.photos/id/85/1080/",
        1451638679, // 01/01/2016
      ),
      Post(
        "1",
        "Laughing History",
        "He learned the important lesson that a picnic at the beach on a windy day is a bad idea.",
        "",
        1361696994, // 24/02/2013
      ),
      Post(
        "3",
        "Woman of Years",
        "After fighting off the alligator, Brian still had to face the anaconda.",
        null,
        1346601558, // 02/09/2012
      ),
      Post(
        "2",
        "The Invisible Window",
        null,
        "https://picsum.photos/id/40/1080/",
        1210645031, // 13/05/2008
      ),
    )
  )
  
  override fun getPostsOrderByCreationDateDesc(): Flow<List<Post>> =
    posts
  
  override fun addPost(post: Post) {
    posts.value.add(0, post)
  }
  
}