package com.debashis.portfolio

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrightnessHigh
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

import androidx.navigation.NavHostController
import androidx.navigation.compose.*

sealed class Screen(val route: String, val title: String) {
    object About : Screen("about", "About")
    object Skills : Screen("skills", "Skills")
    object Projects : Screen("projects", "Projects")
    object Contact : Screen("contact", "Contact")
}

@Composable
fun PortfolioApp(
    isDark: Boolean,
    onToggleTheme: () -> Unit
) {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "My Portfolio",
                        color = MaterialTheme.colors.onPrimary
                    )
                },
                backgroundColor = MaterialTheme.colors.primary,
                actions = {
                    IconButton(onClick = onToggleTheme) {
                        Icon(
                            imageVector = if (isDark) Icons.Default.BrightnessHigh else Icons.Default.DarkMode,
                            contentDescription = "Toggle Theme",
                            tint = MaterialTheme.colors.onPrimary
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            NavHost(
                navController = navController,
                startDestination = Screen.About.route
            ) {
                composable(Screen.About.route) { AboutScreen() }
                composable(Screen.Skills.route) { SkillsScreen() }
                composable(Screen.Projects.route) { ProjectsScreen() }
                composable(Screen.Contact.route) { ContactScreen() }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(Screen.About, Screen.Skills, Screen.Projects, Screen.Contact)
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.onSurface
    ) {
        items.forEach { screen ->
            BottomNavigationItem(
                selected = currentRoute == screen.route,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                label = { Text(screen.title) },
                icon = {}, // Optional: add icons here if needed
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = MaterialTheme.colors.onSurface.copy(alpha = 0.6f)
            )
        }
    }
}
