package uz.turgunboyevjurabek.navigation

import androidx.compose.animation.core.animate
import androidx.compose.animation.core.estimateAnimationDurationMillis
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.text.style.TextAlign.Companion.End
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {

    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.rout,

    ){
        composable(route=Screen.MainScreen.rout){
            MainScreen(navController = navController)
        }
        composable(route=Screen.DetailScreen.rout+"/{name}",
            arguments = listOf(navArgument("name")
            {
                type= NavType.StringType
                defaultValue="defaultValue"
                nullable=true
        })
        ){
            DetailScreen(name = it.arguments?.getString("name"))
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                if (text.isNotEmpty()){
                    navController.navigate(Screen.DetailScreen.withArgs(text))
                }
                      },

            modifier = Modifier.align(Alignment.End)
        ) {}
    }

}

@Composable
fun DetailScreen(name:String?) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()){
        Text(text = "Salom $name")

    }
}