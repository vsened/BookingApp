package com.vsened.bookingapp.presentation.screens.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vsened.bookingapp.R
import com.vsened.bookingapp.presentation.ui.theme.sanFrancisco

@Composable
fun UserRating() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .background(Color(0x33FFC700))
            .padding(start = 10.dp, end = 10.dp, top = 3.dp, bottom = 5.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.star_22),
            contentDescription = "User Rating Icon",
            tint = Color(0xffFFA800)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "5 Превосходно",
            fontFamily = sanFrancisco,
            fontSize = 16.sp,
            color = Color(0xFFFFA800)
        )
    }
}



@Preview
@Composable
fun UserRatingPreview() {
    UserRating()
}