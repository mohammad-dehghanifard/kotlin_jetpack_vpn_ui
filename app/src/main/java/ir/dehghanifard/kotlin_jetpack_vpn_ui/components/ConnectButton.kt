package ir.dehghanifard.kotlin_jetpack_vpn_ui.components

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import ir.dehghanifard.kotlin_jetpack_vpn_ui.R
import ir.dehghanifard.kotlin_jetpack_vpn_ui.helpers.ConnectionStatus

@Composable
fun ConnectButton() {
    var connectionStatus by remember { mutableStateOf(ConnectionStatus.DisConnect) }
    Column (horizontalAlignment = Alignment.CenterHorizontally){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp),
        ) {
            // show status
            when (connectionStatus) {
                ConnectionStatus.DisConnect -> {
                    Icon(
                        painterResource(id = R.drawable.circle),
                        contentDescription = null,
                        modifier = Modifier
                            .size(250.dp)
                            .align(Alignment.Center)
                    )
                }

                ConnectionStatus.Connecting -> {
                    GlideImage(
                        imageModel = { R.drawable.connecting }, // loading a network image using an URL.
                        imageOptions = ImageOptions(
                            contentScale = ContentScale.Crop,
                            alignment = Alignment.Center
                        ),
                        modifier = Modifier
                            .size(350.dp)
                            .align(Alignment.Center)
                    )
                }

                ConnectionStatus.Connected -> {
                    GlideImage(
                        imageModel = { R.drawable.connected }, // loading a network image using an URL.
                        imageOptions = ImageOptions(
                            contentScale = ContentScale.Crop,
                            alignment = Alignment.Center
                        ),
                        modifier = Modifier
                            .size(350.dp)
                            .align(Alignment.Center)
                    )
                }


            }

            IconButton(
                onClick = {
                    when (connectionStatus) {
                        ConnectionStatus.DisConnect -> {
                            connectionStatus = ConnectionStatus.Connecting
                            Handler(Looper.getMainLooper()).postDelayed({
                                connectionStatus = ConnectionStatus.Connected
                            }, 3000)
                        }

                        ConnectionStatus.Connecting -> {}
                        ConnectionStatus.Connected -> connectionStatus = ConnectionStatus.DisConnect
                    }

                },
                //enabled = connectionStatus == Connected || connectionStatus == DisConnect,
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.Center)
            ) {
                Icon(
                    painterResource(id = R.drawable.power),
                    contentDescription = null,
                    tint = Color.White,

                    )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row {
            Icon(painter = painterResource(id = getStatusIcon(connectionStatus)), contentDescription = null , tint = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = connectionStatus.name, color = Color.White)

        }

    }
}

private fun getStatusIcon(connection : ConnectionStatus) : Int {
    return when(connection){
        ConnectionStatus.DisConnect -> R.drawable.ic_baseline_gpp_bad_24
        ConnectionStatus.Connecting -> R.drawable.ic_baseline_sync_24
        ConnectionStatus.Connected -> R.drawable.ic_baseline_gpp_good_24
    }
}