package ru.myitacademy.composedemo.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.myitacademy.composedemo.ui.MainViewModel
import ru.myitacademy.composedemo.ui.screens.lazy_list.LazyListScreen
import ru.myitacademy.composedemo.ui.screens.recycler_view.RecyclerViewScreen

@Composable
fun AppNavigation(
    navHostController: NavHostController,
    viewModel: MainViewModel
) {

    NavHost(
        navController = navHostController,
        startDestination = AppScreen.LazyList.route
    ) {
        composable(
            route = AppScreen.LazyList.route
        ) {
            LazyListScreen(viewModel)
        }

        composable(
            route = AppScreen.RecyclerView.route
        ) {
            RecyclerViewScreen(viewModel)
        }
    }
}