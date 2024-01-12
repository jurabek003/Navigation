package uz.turgunboyevjurabek.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {

    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.rout){
        composable(route=Screen.MainScreen.rout){
            Screen.MainScreen(navController=navController)
        }
    }
}