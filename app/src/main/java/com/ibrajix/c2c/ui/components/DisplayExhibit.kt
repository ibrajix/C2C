package com.ibrajix.c2c.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ibrajix.c2c.R
import com.ibrajix.c2c.data.model.Exhibit
import com.ibrajix.c2c.ui.theme.greyBg
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun DisplayExhibit(exhibit: Exhibit, modifier: Modifier = Modifier){


    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = exhibit.title,
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onPrimary
        )

        LazyRow(
            modifier = modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            contentPadding = PaddingValues(
                top = 10.dp,
                bottom = 10.dp,
                end = 10.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            items(exhibit.images) { imageUrl->

                Box(
                    modifier = modifier
                        .size(250.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(MaterialTheme.colors.greyBg)
                        .align(Alignment.CenterHorizontally)
                        .padding(10.dp),
                    contentAlignment = Alignment.Center
                ){
                    GlideImage(
                        modifier = modifier
                            .size(200.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .padding(end = 10.dp, bottom = 10.dp, top = 10.dp),
                        imageOptions = ImageOptions(
                            alignment = Alignment.Center,
                        ),
                        loading = {
                            Image(
                                modifier = modifier.align(Alignment.Center),
                                painter = painterResource(id = R.drawable.ic_loading), contentDescription = null
                            )
                        },
                        failure = {
                            Image(
                                modifier = modifier.align(Alignment.Center),
                                painter = painterResource(id = R.drawable.ic_failed), contentDescription = null
                            )
                        },
                        imageModel = imageUrl
                    )
                }
            }
        }
    }
}