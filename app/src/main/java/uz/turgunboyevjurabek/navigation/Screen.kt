package uz.turgunboyevjurabek.navigation

sealed class Screen(val rout:String) {
    object MainScreen:Screen("main_screen")
    object DetailScreen:Screen("detail_screen")
}