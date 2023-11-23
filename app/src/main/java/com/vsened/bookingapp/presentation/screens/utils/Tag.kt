package com.vsened.bookingapp.presentation.screens.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vsened.bookingapp.presentation.ui.theme.sanFrancisco

@Composable
fun Tag(tag: String) {
    Text(
        modifier = Modifier
            .clip(RoundedCornerShape(3.dp))
            .background(Color(0xFFFBFBFC))
            .padding(top = 3.dp, bottom = 3.dp, start = 5.dp, end = 5.dp),
        text = tag,
        fontFamily = sanFrancisco,
        fontSize = 18.sp,
        color = Color(0xFF828796)
    )
}

@Preview
@Composable
fun TagPreview() {
    Tag(tag = "3-я линия")
}