package com.example.lelekart.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DealOfDay() {
    Card(
       elevation = CardDefaults.cardElevation(
           defaultElevation = 2.dp
       ),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFF3E0)
        ),
        shape = MaterialTheme.shapes.medium,

        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("DEAL OF THE DAY", color = Color.Red, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(4.dp))
            Text("High Power Car Vacuum Wet/Dry Hi-Power Portable Wet Dry-Vacuum Super Clean for Cleaning", fontWeight = FontWeight.SemiBold)
            Spacer(Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("₹329.80", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Spacer(Modifier.width(8.dp))
                Text("₹388.00", textDecoration = TextDecoration.LineThrough, color = Color.Gray)
                Spacer(Modifier.width(8.dp))
                Text("15% off", color = Color(0xFF388E3C))
            }
        }
    }
}