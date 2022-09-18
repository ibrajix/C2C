package com.ibrajix.c2c.ui.screens.activity.start

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.livedata.observeAsState
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ibrajix.c2c.navigation.SetUpNavGraph
import com.ibrajix.c2c.storage.StorageViewModel
import com.ibrajix.c2c.ui.theme.C2CTheme
import com.ibrajix.c2c.utils.GeneralUtility.isDarkThemeOn
import com.ibrajix.c2c.utils.GeneralUtility.transparentStatusBar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    private val viewModel: StorageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        if(!isDarkThemeOn()){
            transparentStatusBar()
        }
        setContent {

            val darkTheme = viewModel.selectedTheme.observeAsState(initial = false)
            val systemUiController = rememberSystemUiController()

            C2CTheme(darkTheme.value) {
               navController = rememberNavController()
                SetUpNavGraph(navController = navController)
            }
        }
    }
}