package ru.myitacademy.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.sp
import ru.myitacademy.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val screens = listOf(
                AppScreen(
                    name = "First",
                    icon = Icons.Default.Person
                ),
                AppScreen(
                    name = "Second",
                    icon = Icons.Default.Share
                ),
                AppScreen(
                    name = "Third",
                    icon = Icons.Default.ShoppingCart
                )
            )

            var counter by remember { mutableStateOf(0) }
            var isTextShown  by remember { mutableStateOf(true) }

            val scaffoldState = rememberScaffoldState()

            var selectedScreen by remember {
                mutableStateOf(screens.first())
            }

            val scope = rememberCoroutineScope()

            ComposeDemoTheme {

                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(selectedScreen.name)
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
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Button(
                                onClick = {
                                    counter++
                                    isTextShown = !isTextShown
                                }
                            ) {
                                Icon(
                                    imageVector = selectedScreen.icon,
                                    contentDescription = null
                                )
                                Text(text = "Increment")
                            }

                            if (isTextShown) {
                                repeat(10) {
                                    Text(
                                        text = counter.toString(),
                                        fontSize = 36.sp
                                    )
                                }
                            }
                        }
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {}
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = null
                            )
                        }
                    },
                    bottomBar = {
                        BottomNavigation {
                            screens.forEach { screen ->
                                BottomNavigationItem(
                                    selected = selectedScreen == screen,
                                    onClick = {
                                        selectedScreen = screen
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = screen.icon,
                                            contentDescription = null
                                        )
                                    },
                                    label = {
                                        Text(text = screen.name)
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

data class AppScreen(
    val name: String,
    val icon: ImageVector
)