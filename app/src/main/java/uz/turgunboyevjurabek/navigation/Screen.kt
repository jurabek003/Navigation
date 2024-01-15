package uz.turgunboyevjurabek.navigation

sealed class Screen(val rout:String) {
    object MainScreen:Screen("main_screen")
    object DetailScreen:Screen("detail_screen")

    fun withArgs(vararg args:String):String{
        return buildString {
            append(rout)
                args.forEach { arg->
                    append("/$arg")
                }
        }
    }
}