package com.vsened.bookingapp.presentation.screens.hotelscreen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
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
import com.vsened.bookingapp.presentation.screens.utils.Tag
import com.vsened.bookingapp.presentation.ui.theme.sanFrancisco

@Composable
fun HotelCard() {
    val tags = listOf(
        "3-я линия",
        "Платный Wi-Fi в фойе",
        "30 км от аэропорта",
        "1 км от пляжа"
    )
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )
    ) {
        Text(
            text = "Об отеле",
            fontFamily = sanFrancisco,
            fontSize = 25.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
        )
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            mainAxisSpacing = 10.dp,
            crossAxisSpacing = 10.dp,
        ) {
            tags.forEach { tag ->
                Tag(tag = tag)
            }
        }
        Text(
            text = "Отель VIP-класса с собственными гольф полями. Высокий уровнь сервиса. Рекомендуем для респектабельного отдыха. Отель принимает гостей от 18 лет!",
            fontFamily = sanFrancisco,
            fontSize = 17.sp,
            modifier = Modifier.padding(16.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(Color(0xFFFBFBFC))
        ) {
            Column(
                modifier = Modifier.padding(15.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(bottom = 7.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.emoji_happy),
                        contentDescription = null,
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = "Удобства",
                            fontFamily = sanFrancisco
                        )
                        Text(
                            text = "Самое необходимое",
                            fontFamily = sanFrancisco,
                            color =  Color(0xFF828796),
                            fontSize = 12.sp
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(imageVector = ImageVector.vectorResource(R.drawable.icons), contentDescription = null )
                }
                Divider(
                    modifier = Modifier.padding(start = 40.dp, end = 40.dp),
                    color = Color(0x26828796)
                    )
                Row(
                    modifier = Modifier.padding(top = 7.dp, bottom = 7.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.tick_square),
                        contentDescription = null,
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = "Что включено",
                            fontFamily = sanFrancisco
                        )
                        Text(
                            text = "Самое необходимое",
                            fontFamily = sanFrancisco,
                            color =  Color(0xFF828796),
                            fontSize = 12.sp
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(imageVector = ImageVector.vectorResource(R.drawable.icons), contentDescription = null )
                }
                Divider(
                    modifier = Modifier.padding(start = 40.dp, end = 40.dp),
                    color = Color(0x26828796)
                )
                Row(
                    modifier = Modifier.padding(top = 7.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.close_square),
                        contentDescription = null,
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = "Что не включено",
                            fontFamily = sanFrancisco
                        )
                        Text(
                            text = "Самое необходимое",
                            fontFamily = sanFrancisco,
                            color =  Color(0xFF828796),
                            fontSize = 12.sp
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(imageVector = ImageVector.vectorResource(R.drawable.icons), contentDescription = null )
                }
            }
        }


        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview
@Composable
fun HotelCardPreview() {
    HotelCard()
}

