package dev.sunnat629.dimesforall

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun MohiDimens(content: @Composable () -> Unit) {
    val configuration = LocalConfiguration.current
    val dimensions = when {
        configuration.screenWidthDp <= 120 && configuration.screenWidthDp < 160 -> ldpi_120dpi
        configuration.screenWidthDp <= 160 && configuration.screenWidthDp < 240 -> mdpi_160dpi
        configuration.screenWidthDp <= 240 && configuration.screenWidthDp < 320 -> hdpi_240dpi
        configuration.screenWidthDp <= 320 && configuration.screenWidthDp < 480 -> xhdpi_320dpi
        configuration.screenWidthDp <= 480 && configuration.screenWidthDp < 640 -> xxhdpi_480dpi
        configuration.screenWidthDp <= 640 -> xxxhdpi_640dpi
        else -> mdpi_160dpi
    }

    val dimensionSet = remember { dimensions }
    val localAppDimens = staticCompositionLocalOf { mdpi_160dpi }
    CompositionLocalProvider(localAppDimens provides dimensionSet, content = content)
}