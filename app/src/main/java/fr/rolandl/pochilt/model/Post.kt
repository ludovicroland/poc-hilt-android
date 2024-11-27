package fr.rolandl.pochilt.model

import java.io.Serializable

data class Post(
  /**
   * Unique identifier for the Post.
   */
  val id: String,
  
  /**
   * Title of the Post.
   */
  val title: String,
  
  /**
   * Optional description for the Post.
   */
  val description: String?,
  
  /**
   * URL of an image associated with the Post, if any.
   */
  val photoUrl: String?,
  
  /**
   * Timestamp representing the creation date and time of the Post in milliseconds since epoch.
   */
  val timestamp: Long,
) : Serializable