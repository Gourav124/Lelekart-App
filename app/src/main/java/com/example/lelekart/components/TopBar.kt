package com.example.lelekart.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lelekart.R
import java.nio.file.WatchEvent

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFA726))
            .fillMaxHeight()
            .padding(18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "LELEKART",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 22.sp,
            modifier = Modifier.padding(top = 20.dp)
        )
    }

    Row(modifier = Modifier.fillMaxWidth()) {
        IconButton(
            onClick = {},
            modifier = Modifier.background(Color(0xFFFFF3E0))
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search_icon"
            )
        }
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Search for Products...") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.White, MaterialTheme.shapes.small),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFFFF3E0),
                unfocusedContainerColor = Color(0xFFFFF3E0),
                disabledContainerColor = Color(0xFFFFF3E0),
                focusedIndicatorColor = Color(0xFFFFF3E0),
                unfocusedIndicatorColor = Color(0xFFFFF3E0),
            )
        )
    }
}