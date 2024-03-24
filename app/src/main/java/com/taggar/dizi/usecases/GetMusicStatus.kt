package com.taggar.dizi.usecases

import android.content.Context
import com.taggar.dizi.ui.home.MusicStatus
import com.taggar.dizi.usecases.base.Usecase
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import javax.inject.Inject


class GetMusicStatus @Inject constructor(
    @ApplicationContext private val context: Context
) : Usecase<Unit, Flow<MusicStatus>> {
    override suspend fun invoke(param: Unit) = channelFlow {
        send(MusicStatus(isPlaying = false))
    }
}