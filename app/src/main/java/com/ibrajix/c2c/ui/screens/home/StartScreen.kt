package com.ibrajix.c2c.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ibrajix.c2c.R
import com.ibrajix.c2c.navigation.Routes

@Composable
fun StartScreen(
     modifier: Modifier = Modifier,
     navigateToHomeScreen : () -> Unit,
)
{

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = MaterialTheme.colors.secondary
    )

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.crop_tractor))
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.secondary),
        verticalArrangement = Arrangement.SpaceAround,

    ) {

        Text(
            modifier = modifier
                .padding(start = 50.dp, end = 50.dp, top = 30.dp)
                .testTag("Welcome Text"),
            text = stringResource(id = R.string.welcome_to_crop2farm),
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )

        Box(modifier = modifier
            .size(300.dp)
            .align(Alignment.CenterHorizontally),
        ){
            LottieAnimation(composition = composition , progress = { progress })
        }

        Button(
            modifier = modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 20.dp, end = 20.dp),
            shape = RoundedCornerShape(8.dp),

            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primary,
            ),
            onClick = {
                //navigate
                navigateToHomeScreen()
            },
        )
        {
            Text(
                text = stringResource(R.string.continuee),
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.onPrimary,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }

    }

}