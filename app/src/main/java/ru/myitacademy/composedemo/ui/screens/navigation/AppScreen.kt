package ru.myitacademy.composedemo.ui.screens.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector
import ru.myitacademy.composedemo.R

sealed class AppScreen(
    val route: String,
    @StringRes val nameResource: Int,
    val icon: ImageVector
) {
    object LazyList: AppScreen("lazylist", R.string.screen_lazy_list, Icons.Default.List)
    object RecyclerView: AppScreen("recyclerview", R.string.screen_recycler_view, Icons.Default.Build)

    companion object {
        fun getAll() = listOf(
            LazyList,
            RecyclerView
        )
    }
}


