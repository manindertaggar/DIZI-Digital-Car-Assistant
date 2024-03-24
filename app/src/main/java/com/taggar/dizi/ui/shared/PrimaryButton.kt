package com.taggar.dizi.ui.shared

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(20.dp), // Rounded corners
        modifier = Modifier.padding(15.dp)
    ) {
        Text(text = text, color = Color.Black) // Text color
    }
}

@Preview
@Composable
private fun PreviewButton() {
    PrimaryButton(onClick = { /* Handle button click */ }, text = "Primary Button")
}