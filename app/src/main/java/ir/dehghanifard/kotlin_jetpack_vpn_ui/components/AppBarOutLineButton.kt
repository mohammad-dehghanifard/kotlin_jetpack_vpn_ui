package ir.dehghanifard.kotlin_jetpack_vpn_ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ir.dehghanifard.kotlin_jetpack_vpn_ui.ui.theme.AppWhiteOpacity

@Composable
fun AppBarOutLineButton(icon : Int) {
    OutlinedButton(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp, AppWhiteOpacity),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = Color.White,
        ),

        ) {
        Icon(
            painter = painterResource(id = icon),
            tint = Color.White,
            contentDescription = null
        )
    }
}