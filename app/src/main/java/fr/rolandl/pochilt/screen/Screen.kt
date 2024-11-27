package fr.rolandl.pochilt.screen

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
  val route: String,
  val navArguments: List<NamedNavArgument> = emptyList()
) {
  
  data object FirstScreen : Screen("main")
  
  data object Home : Screen(
    route = "home/{id}",
    navArguments = listOf(navArgument("id") {
      type = NavType.IntType
    })
  ) {
    
    fun createRoute(id: Int) =
      "home/$id"
  }
}
