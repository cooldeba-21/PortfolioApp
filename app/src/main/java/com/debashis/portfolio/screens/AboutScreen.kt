package com.debashis.portfolio

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun AboutScreen() {
    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { visible = true }

    AnimatedVisibility(
        visible = visible,
        enter = fadeIn() + slideInVertically(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.ic_profile_placeholder),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                shape = RoundedCornerShape(16.dp),
                elevation = 8.dp,
                backgroundColor = Color(0xFF0D47A1) // Deep Techy Blue
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Debashis Mohapatra",
                        style = MaterialTheme.typography.h6,
                        color = Color.White
                    )
                    Text(
                        text = "Sophomore at NIT Rourkela | B.Tech in EE",
                        style = MaterialTheme.typography.body2,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                shape = RoundedCornerShape(12.dp),
                backgroundColor = Color(0xFF1976D2),
                elevation = 6.dp
            ) {
                Text(
                    text = "Passionate about electronics, IoT, Arduino, ESP32, PCB design, and frontend dev with smooth animations and 3D effects.",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.body2,
                    color = Color.White
                )
            }
        }
    }
}
