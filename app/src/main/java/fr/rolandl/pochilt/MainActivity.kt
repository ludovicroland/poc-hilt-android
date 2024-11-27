package fr.rolandl.pochilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import fr.rolandl.pochilt.screen.MainScreen
import fr.rolandl.pochilt.screen.Screen
import fr.rolandl.pochilt.screen.home.DetailScreen
import fr.rolandl.pochilt.ui.theme.PocHiltTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      val navController = rememberNavController()
      
      PocHiltTheme {
        MyNavHost(navController)
      }
    }
  }
}

@Composable
fun MyNavHost(navHostController: NavHostController) {
  NavHost(
    navController = navHostController,
    startDestination = Screen.FirstScreen.route
  ) {
    composable(Screen.FirstScreen.route) {
      MainScreen {
        navHostController.navigate(Screen.Home.createRoute(4))
      }
    }
    composable(
      route = Screen.Home.route,
      arguments = Screen.Home.navArguments
    ) {
      DetailScreen()
    }
  }
}