package com.taggar.dizi.ui.shared

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SecondaryButton(
    text: String, onClick: () -> Unit
) {
    Button(
        onClick = onClick, modifier = Modifier.padding(15.dp)

    ) {
        Text(text = text, color = Color.DarkGray) // Text color
    }
}

@Preview
@Composable
private fun PreviewButton() {
    SecondaryButton(onClick = { /* Handle button click */ }, text = "Primary Button")
}