package ir.dehghanifard.kotlin_jetpack_vpn_ui.components
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ir.dehghanifard.kotlin_jetpack_vpn_ui.R

@Composable
fun AppTopAppBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AppBarOutLineButton(R.drawable.ic_dashboard)
        AppBarOutLineButton(R.drawable.ic_settings)
    }
}