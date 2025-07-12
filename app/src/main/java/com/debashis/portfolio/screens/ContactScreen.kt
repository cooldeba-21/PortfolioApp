package com.debashis.portfolio

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ContactScreen() {
    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { visible = true }

    AnimatedVisibility(
        visible = visible,
        enter = fadeIn() + slideInVertically()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Card(
                shape = RoundedCornerShape(16.dp),
                elevation = 8.dp,
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Contact", style = MaterialTheme.typography.h6, color = MaterialTheme.colors.onPrimary)
                    Spacer(modifier = Modifier.height(12.dp))
                    Text("Email: debashismohapatra8260@gmail.com", color = MaterialTheme.colors.onPrimary)
                    Text("LinkedIn: linkedin.com/in/debashis-mohapatra", color = MaterialTheme.colors.onPrimary)
                    Text("GitHub: github.com/debashis-mohapatra", color = MaterialTheme.colors.onPrimary)
                }
            }
        }
    }
}
