package ir.dehghanifard.kotlin_jetpack_vpn_ui
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import ir.dehghanifard.kotlin_jetpack_vpn_ui.components.AppTopAppBar
import ir.dehghanifard.kotlin_jetpack_vpn_ui.components.ConnectButton
import ir.dehghanifard.kotlin_jetpack_vpn_ui.helpers.ConnectionStatus
import ir.dehghanifard.kotlin_jetpack_vpn_ui.helpers.ConnectionStatus.*
import ir.dehghanifard.kotlin_jetpack_vpn_ui.ui.theme.AppBackground1
import ir.dehghanifard.kotlin_jetpack_vpn_ui.ui.theme.AppBackground2
import ir.dehghanifard.kotlin_jetpack_vpn_ui.ui.theme.Kotlin_jetpack_vpn_uiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_jetpack_vpn_uiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainView()
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun MainView() {
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(colors = listOf(AppBackground1, AppBackground2))
            ),

    ) {

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),) {
            // app bar
            AppTopAppBar()
            Spacer(modifier = Modifier.height(20.dp) )
            // power key
            ConnectButton()
        }

    }
}








