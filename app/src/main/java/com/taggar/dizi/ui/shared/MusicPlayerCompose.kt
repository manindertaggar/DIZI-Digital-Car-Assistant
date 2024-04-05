package com.taggar.dizi.ui.shared

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.taggar.dizi.models.MusicStatusSimple

@Composable
fun MusicPlayerCompose(musicStatus: MusicStatusSimple) {

        Text(text = musicStatus.packageName + " : " + musicStatus.isPlaying, color = Color.Red)
}
