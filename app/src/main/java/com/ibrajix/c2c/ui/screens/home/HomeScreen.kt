package com.ibrajix.c2c.ui.screens.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ibrajix.c2c.R
import com.ibrajix.c2c.ui.components.DisplayExhibit
import com.ibrajix.c2c.ui.components.DisplaySnackBar
import com.ibrajix.c2c.ui.components.StatelessSwitch
import com.ibrajix.c2c.ui.viewmodel.MainViewModel
import com.ibrajix.c2c.utils.GeneralUtility
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeScreen(
    mainViewModel: MainViewModel,
    modifier: Modifier = Modifier,
){

    var snackMessage: String? = null

    var refreshing by remember { mutableStateOf(false) }


    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = MaterialTheme.colors.primary
    )


    val context = LocalContext.current

    val isLoading = mainViewModel.loading.collectAsState()
    val data = mainViewModel.data.collectAsState()
    val checkedState = rememberSaveable { mutableStateOf(false) }
    var shouldDisplaySnackBar by remember { mutableStateOf(false) }
    var errorMessage = ""

    LaunchedEffect(key1 =  context, block = {

        if (GeneralUtility.isConnectedToInternet(context)){
            mainViewModel.getData()
        }
        else{
           Toast.makeText(context, R.string.not_connected, Toast.LENGTH_SHORT).show()
        }

        mainViewModel.errorMessage
            .collect { message ->
                if (message.isNotEmpty()){
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                }
            }

    })

    LaunchedEffect(refreshing){
        if (refreshing){
            mainViewModel.getData()
            delay(2000)
            refreshing = false
        }
    }

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = refreshing),
        onRefresh = { refreshing = true },
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.primary)
                .padding(20.dp),
        ) {

            Row(
                modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = stringResource(id = R.string.hello_ibrajix),
                    style = MaterialTheme.typography.h1,
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.onPrimary,
                )

                StatelessSwitch(switchState = checkedState)

            }

            if (isLoading.value){
                Column(modifier = modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator(
                        color = MaterialTheme.colors.onPrimary
                    )
                }
            }
            else{
                Column(modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                ) {
                    data.value?.forEach { exhibit->
                        DisplayExhibit(exhibit)
                    }
                }

            }
        }
    }
}