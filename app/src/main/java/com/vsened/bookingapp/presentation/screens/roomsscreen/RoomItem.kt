package com.vsened.bookingapp.presentation.screens.roomsscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowRow
import com.vsened.bookingapp.R
import com.vsened.bookingapp.domain.model.Room
import com.vsened.bookingapp.presentation.screens.utils.ImageSlider
import com.vsened.bookingapp.presentation.ui.theme.ButtonBackground
import com.vsened.bookingapp.presentation.ui.theme.sanFrancisco

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RoomItem(
    room: Room,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        ImageSlider(
            room.images
        )
        Text(
            text = room.name,
            fontFamily = sanFrancisco,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            fontWeight = FontWeight.Medium,
            fontSize = 23.sp
        )
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            mainAxisSpacing = 10.dp,
            crossAxisSpacing = 10.dp,
        ) {
            room.tags.forEach {
                Text(
                    modifier = Modifier
                        .clip(RoundedCornerShape(3.dp))
                        .background(Color(0xFFFBFBFC))
                        .padding(top = 4.dp, bottom = 4.dp, start = 10.dp, end = 10.dp),
                    text = it,
                    fontFamily = sanFrancisco,
                    color = Color(0xFF828796)
                )
            }
        }
        Row(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 5.dp, bottom = 5.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(Color(0x1A0D72FF))
                .padding(start = 10.dp, end = 10.dp, top = 1.dp, bottom = 3.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Подробнее о номере",
                fontFamily = sanFrancisco,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF0D72FF)
            )
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.icons),
                contentDescription = null,
                tint = Color(0xFF0D72FF)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = "${room.price / 1000} ${room.price % 1000} ₽",
                fontFamily = sanFrancisco,
                fontWeight = FontWeight.Medium,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = room.period,
                fontFamily = sanFrancisco,
                fontSize = 16.sp,
                color = Color(0xFF828796),
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = ButtonBackground,
                disabledContainerColor = ButtonBackground
            ),
            onClick = { onClick() }
        ) {
            Text(
                text = "Выбрать номер",
                fontFamily = sanFrancisco,
                modifier = Modifier.padding(top = 7.dp, bottom = 7.dp)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
    }
}
