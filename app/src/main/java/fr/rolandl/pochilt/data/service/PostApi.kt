package fr.rolandl.pochilt.data.service

import fr.rolandl.pochilt.model.Post
import kotlinx.coroutines.flow.Flow

interface PostApi {
  /**
   * Retrieves a list of Posts ordered by their creation date in descending order.
   *
   * @return A list of Posts sorted by creation date (newest first).
   */
  fun getPostsOrderByCreationDateDesc(): Flow<List<Post>>
  
  /**
   * Adds a new Post to the data source.
   *
   * @param post The Post object to be added.
   */
  fun addPost(post: Post)
}