package ru.myitacademy.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import ru.myitacademy.composedemo.data.Record
import ru.myitacademy.composedemo.ui.MainViewModel
import ru.myitacademy.composedemo.ui.screens.lazy_list.LazyListScreen
import ru.myitacademy.composedemo.ui.screens.navigation.AppNavigation
import ru.myitacademy.composedemo.ui.screens.navigation.AppScreen
import ru.myitacademy.composedemo.ui.screens.recycler_view.RecyclerViewScreen
import ru.myitacademy.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {

    val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val screens = AppScreen.getAll()

            val scaffoldState = rememberScaffoldState()

            var selectedScreen by remember {
                mutableStateOf(screens.first())
            }

            val navController = rememberNavController()

            ComposeDemoTheme {

                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(stringResource(selectedScreen.nameResource))
                            },
                            actions = {
                                IconButton(onClick = {}) {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = null
                                    )
                                }
                            }
                        )
                    },
                    content = {
                        Box(
                            modifier = Modifier.padding(it)
                        ) {
                            AppNavigation(
                                navHostController = navController,
                                viewModel = mainViewModel
                            )
                        }
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                                mainViewModel.addRecord(
                                    Record(
                                        heading = "Whatever",
                                        subtext = "Subtext"
                                    )
                                )
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = null
                            )
                        }
                    },
                    bottomBar = {
                        BottomNavigation {
                            AppScreen.getAll().forEach { screen ->
                                BottomNavigationItem(
                                    selected = selectedScreen == screen,
                                    onClick = {
                                        selectedScreen = screen
                                        navController.navigate(screen.route)
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = screen.icon,
                                            contentDescription = null
                                        )
                                    },
                                    label = {
                                        Text(text = stringResource(screen.nameResource))
                                    },
                                    alwaysShowLabel = false
                                )
                            }
                        }
                    }
                )
            }
        }
    }
}