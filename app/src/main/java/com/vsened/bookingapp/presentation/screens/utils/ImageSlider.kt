package com.vsened.bookingapp.presentation.screens.utils

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vsened.bookingapp.R
import com.vsened.bookingapp.presentation.ui.theme.Black10
import com.vsened.bookingapp.presentation.ui.theme.Black17
import com.vsened.bookingapp.presentation.ui.theme.Black22
import com.vsened.bookingapp.presentation.ui.theme.Black5
import kotlinx.coroutines.launch
import kotlin.math.abs

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSlider(hotels: List<Int>) {
    val coroutineScope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(15.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color.White),
    ) {
        val pagerState = rememberPagerState(
            initialPage = 0
        )
        HorizontalPager(
            pageCount = hotels.size,
            state = pagerState,
            key = {
                hotels[it]
            },
            pageSize = PageSize.Fill
        ) { index ->
            Image(
                painter = painterResource(id = hotels[index]),
                contentDescription = "Hotel image",
                contentScale = ContentScale.Crop
            )
        }
        Row(
            Modifier
                .wrapContentHeight()
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(Color.White)
                .padding(start = 5.dp, end = 5.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(hotels.size) { iteration ->
                val color  = when (abs(pagerState.currentPage - iteration)) {
                    0 -> Color.Black
                    1 -> Black22
                    2 -> Black17
                    3 -> Black10
                    else -> Black5
                }
                Box(
                    modifier = Modifier
                        .padding(start = 2.dp, end = 2.dp, top = 4.dp, bottom = 4.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(5.dp)
                        .clickable {
                            coroutineScope.launch {
                                pagerState.scrollToPage(iteration)
                            }
                        }
                )
            }
        }
    }
}