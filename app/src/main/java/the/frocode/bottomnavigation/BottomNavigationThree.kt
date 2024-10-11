package the.frocode.bottomnavigation

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import the.frocode.bottomnavigation.ui.theme.BottomNavigationTheme


data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)
sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Chat : Screen("chat")
    object Settings : Screen("settings")
}
@OptIn(ExperimentalMaterial3Api::class)
class BottomNavigationThree : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavigationTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                val items = listOf(
                    BottomNavigationItem(
                        title = "Home",
                        selectedIcon = Icons.Filled.Home,
                        unselectedIcon = Icons.Outlined.Home,
                        hasNews = false
                    ),
                    BottomNavigationItem(
                        title = "Chat",
                        selectedIcon = Icons.Filled.Email,
                        unselectedIcon = Icons.Outlined.Email,
                        hasNews = false,
                        badgeCount=45
                    ),
                    BottomNavigationItem(
                        title = "Setting",
                        selectedIcon = Icons.Filled.Settings,
                        unselectedIcon = Icons.Outlined.Settings,
                        hasNews = true
                    )
                )
                var selectedItemIndex by rememberSaveable {
                    mutableStateOf(0)
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold (
                        bottomBar ={
                            NavigationBar {
                                items.forEachIndexed { index, item ->
                                    NavigationBarItem(
                                        selected = selectedItemIndex==index,
                                        onClick = {
                                            selectedItemIndex = index
                                            navController.navigate(
                                                when (index) {
                                                    0 -> Screen.Home.route
                                                    1 -> Screen.Chat.route
                                                    2 -> Screen.Settings.route
                                                    else -> Screen.Home.route
                                                }
                                            )
                                        },
                                        label = {
                                                Text(text=item.title)
                                        },
                                        icon = {
                                            BadgedBox(badge = {
                                                if(item.badgeCount!=null){
                                                    Badge{
                                                        Text(text = item.badgeCount.toString())
                                                    }
                                                }else if(item.hasNews){
                                                    Badge (

                                                    )
                                                }
                                            }) {
                                                androidx.compose.material3.Icon(
                                                    imageVector = if (index == selectedItemIndex) {
                                                             item.selectedIcon
                                                    }else item.unselectedIcon,
                                                    contentDescription = item.title
                                                )
                                            }
                                        })
                                }
                            }
                        }
                    ){ innerPadding->
                        NavHost(
                            navController = navController,
                            startDestination = Screen.Home.route,
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            composable(Screen.Home.route) {
                                HomeScreen()
                            }
                            composable(Screen.Chat.route) {
                                ChatScreen()
                            }
                            composable(Screen.Settings.route) {
                                SettingsScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun HomeScreen() {
    Text(text = "Home Screen")
}

@Composable
fun ChatScreen() {
    Text(text = "Chat Screen")
}

@Composable
fun SettingsScreen() {
    Text(text = "Settings Screen")
}

