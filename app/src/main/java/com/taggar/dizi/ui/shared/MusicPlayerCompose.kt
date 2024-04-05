package com.taggar.dizi.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.taggar.dizi.models.MusicStatusSimple

@Composable
fun MusicPlayerCompose(musicStatus: MusicStatusSimple) {
    Row(
        modifier = Modifier
            .padding(30.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = Color(0x33000000))
    ) {
        Text(text = musicStatus.packageName + " : " + musicStatus.isPlaying)
    }
}
