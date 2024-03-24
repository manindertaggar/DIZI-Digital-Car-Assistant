package com.taggar.dizi.ui.permissions.notificationreader

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.taggar.dizi.R
import com.taggar.dizi.base.openNotificationListenerPermissions
import com.taggar.dizi.ui.shared.PrimaryButton
import com.taggar.dizi.ui.shared.SecondaryButton

@Composable
fun NotificationReader(
    viewModel: NotificationAccessViewModel = hiltViewModel(), navController: NavHostController
) {
    val state by viewModel.state.collectAsState()
    val activity = LocalContext.current as Activity
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp), modifier = Modifier.padding(20.dp)
    ) {
        Text(
            text = stringResource(R.string.notification_access),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .background(
                    color = Color(0x7AFFFFFF), shape = RoundedCornerShape(40.dp)
                )
                .padding(10.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.size(10.dp))
            Image(
                painter = painterResource(id = R.mipmap.ic_launcher),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = stringResource(id = R.string.app_name))
        }
        Text(
            text = stringResource(R.string.message_notification_access),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(10.dp)
        )
        Spacer(Modifier.weight(1f))
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End
        ) {
            PrimaryButton(
                onClick = { activity.openNotificationListenerPermissions() }, text = "Allow"
            )
        }
    }
}