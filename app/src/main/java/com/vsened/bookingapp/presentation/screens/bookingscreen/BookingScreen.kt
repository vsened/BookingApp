package com.vsened.bookingapp.presentation.screens.bookingscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.vsened.bookingapp.R
import com.vsened.bookingapp.domain.model.Tourist
import com.vsened.bookingapp.presentation.Screen
import com.vsened.bookingapp.presentation.screens.utils.UserRating
import com.vsened.bookingapp.presentation.ui.theme.ButtonBackground
import com.vsened.bookingapp.presentation.ui.theme.sanFrancisco


@SuppressLint("MutableCollectionMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingScreen(
    navController: NavController,
    roomId: String,
    viewModel: BookingViewModel = hiltViewModel()
) {

    viewModel.getRoom(roomId)
    val state = viewModel.state

    var phoneNumber by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var firstTourist by remember {
        mutableStateOf(Tourist())
    }
    var secondTourist by remember {
        mutableStateOf(Tourist())
    }
    var isFirstTouristVisible by remember {
        mutableStateOf(true)
    }
    var isSecondTouristVisible by remember {
        mutableStateOf(false)
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Бронирование",
                        fontFamily = sanFrancisco,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.arrow_back),
                        contentDescription = "Back icon",
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.RoomsScreen.route)
                        }
                    )
                }
            )
        },
        bottomBar = {
            Button(
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = ButtonBackground,
                    disabledContainerColor = ButtonBackground
                ),
                onClick = {
                    navController.navigate(Screen.PaidOrderScreen.route)
                }
            ) {
                Text(
                    text = "Оплатить",
                    fontFamily = sanFrancisco,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ) {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White,
                    )
                ) {
                    Spacer(Modifier.height(10.dp))
                    UserRating(state.hotel?.rating ?: "")
                    Spacer(Modifier.height(8.dp))
                    Text(
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        text = state.hotel?.name ?: "",
                        fontFamily = sanFrancisco,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        text = state.hotel?.address ?: "",
                        fontFamily = sanFrancisco,
                        color = Color(0xFF0D72FF)
                    )
                    Spacer(Modifier.height(10.dp))
                }
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White,
                    )
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                    ) {
                        Text(
                            text = "Вылет из",
                            modifier = Modifier.weight(3f),
                            fontFamily = sanFrancisco,
                            fontSize = 16.sp,
                            color = Color(0xFF828796)

                        )
                        Text(
                            text = state.room?.startPoint ?: "",
                            modifier = Modifier.weight(4f),
                            fontFamily = sanFrancisco,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                    ) {
                        Text(
                            text = "Страна, город",
                            modifier = Modifier.weight(3f),
                            fontFamily = sanFrancisco,
                            fontSize = 16.sp,
                            color = Color(0xFF828796)

                        )
                        Text(
                            text = state.room?.endPoint ?: "",
                            modifier = Modifier.weight(4f),
                            fontFamily = sanFrancisco,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                    ) {
                        Text(
                            text = "Даты",
                            modifier = Modifier.weight(3f),
                            fontFamily = sanFrancisco,
                            fontSize = 16.sp,
                            color = Color(0xFF828796)

                        )
                        Text(
                            text = state.room?.dates ?: "",
                            modifier = Modifier.weight(4f),
                            fontFamily = sanFrancisco,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                    ) {
                        Text(
                            text = "Кол-во ночей",
                            modifier = Modifier.weight(3f),
                            fontFamily = sanFrancisco,
                            fontSize = 16.sp,
                            color = Color(0xFF828796)

                        )
                        val nights = state.room?.period?.split(' ')?.get(1) ?: 7
                        Text(
                            text = "$nights ночей",
                            modifier = Modifier.weight(4f),
                            fontFamily = sanFrancisco,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                    ) {
                        Text(
                            text = "Отель",
                            modifier = Modifier.weight(3f),
                            fontFamily = sanFrancisco,
                            fontSize = 16.sp,
                            color = Color(0xFF828796)

                        )
                        Text(
                            text = state.hotel?.name ?: "",
                            modifier = Modifier.weight(4f),
                            fontFamily = sanFrancisco,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                    ) {
                        Text(
                            text = "Номер",
                            modifier = Modifier.weight(3f),
                            fontFamily = sanFrancisco,
                            fontSize = 16.sp,
                            color = Color(0xFF828796)

                        )
                        Text(
                            text = state.room?.name ?: "",
                            modifier = Modifier.weight(4f),
                            fontFamily = sanFrancisco,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                    ) {
                        Text(
                            text = "Питание",
                            modifier = Modifier.weight(3f),
                            fontFamily = sanFrancisco,
                            fontSize = 16.sp,
                            color = Color(0xFF828796)

                        )
                        Text(
                            text = state.hotel?.nutrition ?: "",
                            modifier = Modifier.weight(4f),
                            fontFamily = sanFrancisco,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }

            item {
                Spacer(modifier = Modifier.height(10.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White,
                    )
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        text = "Информация о покупателе",
                        fontFamily = sanFrancisco,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    MaskField(
                        phone = phoneNumber,
                        onPhoneChanged = {
                            phoneNumber = it
                        },
                        mask = "+7 (000) 000-00-00",
                        maskNumber = '0',
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    TextField(
                        value = email,
                        onValueChange = { it ->
                            email = it
                        },
                        label = {
                            Text(
                                text = "Почта",
                                fontFamily = sanFrancisco,
                                color = Color(0xFFA9ABB7)
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color.Black,
                            containerColor = Color(0xFFF6F6F9),
                            disabledIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        maxLines = 1
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Эти данные никому не передаются. После оплаты мы вышли чек на указанный вами номер и почту",
                        fontFamily = sanFrancisco,
                        fontSize = 14.sp,
                        color = Color(0xFFA9ABB7),
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White,
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier
                                .weight(1f),
                            text = "Первый турист",
                            fontFamily = sanFrancisco,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Medium,
                        )
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(RoundedCornerShape(2.dp))
                                .background(Color(0x1A0D72FF))
                                .clickable {
                                    isFirstTouristVisible = !isFirstTouristVisible
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(
                                    if (isFirstTouristVisible) R.drawable.arrow_up else
                                        R.drawable.arrow_down
                                ),
                                contentDescription = "Show touirist info",
                                tint = Color(0xFF0D72FF)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    if (isFirstTouristVisible) {
                        TextField(
                            value = firstTourist.name,
                            onValueChange = { name: String ->
                                firstTourist = firstTourist.copy(
                                    name = name
                                )
                            },
                            label = {
                                Text(
                                    text = "Имя",
                                    fontFamily = sanFrancisco,
                                    color = Color(0xFFA9ABB7)
                                )
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, end = 16.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = Color.Black,
                                containerColor = Color(0xFFF6F6F9),
                                disabledIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            maxLines = 1
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        TextField(
                            value = firstTourist.surname,
                            onValueChange = { it ->
                                firstTourist = firstTourist.copy(
                                    surname = it
                                )
                            },
                            label = {
                                Text(
                                    text = "Фамилия",
                                    fontFamily = sanFrancisco,
                                    color = Color(0xFFA9ABB7)
                                )
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, end = 16.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = Color.Black,
                                containerColor = Color(0xFFF6F6F9),
                                disabledIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            maxLines = 1
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        MaskField(
                            phone = firstTourist.dateOfBirth,
                            onPhoneChanged = {
                                firstTourist = firstTourist.copy(dateOfBirth = it)
                            },
                            mask = "00.00.0000г.",
                            maskNumber = '0',
                            label = "Дата рождения"
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        TextField(
                            value = firstTourist.citizenOf,
                            onValueChange = { it: String ->
                                firstTourist = firstTourist.copy(citizenOf = it)
                            },
                            label = {
                                Text(
                                    text = "Гражданство",
                                    fontFamily = sanFrancisco,
                                    color = Color(0xFFA9ABB7)
                                )
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, end = 16.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = Color.Black,
                                containerColor = Color(0xFFF6F6F9),
                                disabledIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            maxLines = 1
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        MaskField(
                            phone = firstTourist.passportId,
                            onPhoneChanged = {
                                firstTourist = firstTourist.copy(passportId = it)
                            },
                            mask = "00 0000000",
                            maskNumber = '0',
                            label = "Номер загранпаспорта"
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        MaskField(
                            phone = firstTourist.passportValidityPeriod,
                            onPhoneChanged = {
                                firstTourist =
                                    firstTourist.copy(passportValidityPeriod = it)
                            },
                            mask = "00.00.0000",
                            maskNumber = '0',
                            label = "Срок действия загранпаспорта"
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White,
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier
                                .weight(1f),
                            text = "Второй турист",
                            fontFamily = sanFrancisco,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Medium,
                        )
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(RoundedCornerShape(2.dp))
                                .background(Color(0x1A0D72FF))
                                .clickable {
                                    isSecondTouristVisible = !isSecondTouristVisible
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(
                                    if (isSecondTouristVisible) R.drawable.arrow_up else
                                        R.drawable.arrow_down
                                ),
                                contentDescription = "Show touirist info",
                                tint = Color(0xFF0D72FF)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    if (isSecondTouristVisible) {
                        TextField(
                            value = secondTourist.name,
                            onValueChange = { name: String ->
                                secondTourist = secondTourist.copy(
                                    name = name
                                )
                            },
                            label = {
                                Text(
                                    text = "Имя",
                                    fontFamily = sanFrancisco,
                                    color = Color(0xFFA9ABB7)
                                )
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, end = 16.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = Color.Black,
                                containerColor = Color(0xFFF6F6F9),
                                disabledIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            maxLines = 1
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        TextField(
                            value = secondTourist.surname,
                            onValueChange = { it ->
                                secondTourist = secondTourist.copy(
                                    surname = it
                                )
                            },
                            label = {
                                Text(
                                    text = "Фамилия",
                                    fontFamily = sanFrancisco,
                                    color = Color(0xFFA9ABB7)
                                )
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, end = 16.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = Color.Black,
                                containerColor = Color(0xFFF6F6F9),
                                disabledIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            maxLines = 1
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        MaskField(
                            phone = secondTourist.dateOfBirth,
                            onPhoneChanged = {
                                secondTourist = secondTourist.copy(dateOfBirth = it)
                            },
                            mask = "00.00.0000г.",
                            maskNumber = '0',
                            label = "Дата рождения"
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        TextField(
                            value = secondTourist.citizenOf,
                            onValueChange = { it: String ->
                                secondTourist = secondTourist.copy(citizenOf = it)
                            },
                            label = {
                                Text(
                                    text = "Гражданство",
                                    fontFamily = sanFrancisco,
                                    color = Color(0xFFA9ABB7)
                                )
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, end = 16.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = Color.Black,
                                containerColor = Color(0xFFF6F6F9),
                                disabledIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            maxLines = 1
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        MaskField(
                            phone = secondTourist.passportId,
                            onPhoneChanged = {
                                secondTourist = secondTourist.copy(passportId = it)
                            },
                            mask = "00 0000000",
                            maskNumber = '0',
                            label = "Номер загранпаспорта"
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        MaskField(
                            phone = secondTourist.passportValidityPeriod,
                            onPhoneChanged = {
                                secondTourist =
                                    secondTourist.copy(passportValidityPeriod = it)
                            },
                            mask = "00.00.0000",
                            maskNumber = '0',
                            label = "Срок действия загранпаспорта"
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White,
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier
                                .weight(1f),
                            text = "Дополнительный турист",
                            fontFamily = sanFrancisco,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Medium,
                        )
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(RoundedCornerShape(2.dp))
                                .background(Color(0xFF0D72FF))
                                .clickable {
                                    viewModel.addTourist(Tourist())
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.add),
                                contentDescription = "Add tourist info",
                                tint = Color.White
                            )
                        }
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White,
                    )
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                    ) {
                        Text(
                            text = "Тур",
                            modifier = Modifier.weight(1f),
                            fontFamily = sanFrancisco,
                            fontSize = 16.sp,
                            color = Color(0xFF828796)

                        )
                        Text(
                            text = "${state.room!!.price / 1000} ${state.room!!.price % 1000} ₽",
                            fontFamily = sanFrancisco,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                    ) {
                        Text(
                            text = "Топливный сбор",
                            modifier = Modifier.weight(1f),
                            fontFamily = sanFrancisco,
                            fontSize = 16.sp,
                            color = Color(0xFF828796)

                        )
                        Text(
                            text = "${state.hotel!!.fuelSurcharge / 1000} " +
                                    "${state.hotel!!.fuelSurcharge % 1000} ₽",
                            fontFamily = sanFrancisco,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                    ) {
                        Text(
                            text = "Сервисный сбор",
                            modifier = Modifier.weight(1f),
                            fontFamily = sanFrancisco,
                            fontSize = 16.sp,
                            color = Color(0xFF828796)

                        )
                        Text(
                            text = "${state.hotel!!.serviceSurcharge / 1000} " +
                                    "${state.hotel!!.serviceSurcharge % 1000} ₽",
                            fontFamily = sanFrancisco,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                    ) {
                        Text(
                            text = "К оплате",
                            modifier = Modifier.weight(1f),
                            fontFamily = sanFrancisco,
                            fontSize = 16.sp,
                            color = Color(0xFF828796)

                        )
                        val totalPrice = state.room!!.price +
                                state.hotel!!.fuelSurcharge +
                                state.hotel!!.serviceSurcharge
                        Text(
                            text = "${totalPrice / 1000} " +
                                    "${if (totalPrice % 1000 > 100) totalPrice % 1000 
                                    else "0${totalPrice % 1000}"} ₽",
                            fontFamily = sanFrancisco,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF0D72FF)
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaskField(
    phone: String,
    modifier: Modifier = Modifier,
    mask: String = "000 000 00 00",
    maskNumber: Char = '0',
    label: String = "Номер телефона",
    onPhoneChanged: (String) -> Unit
) {
    TextField(
        value = phone,
        onValueChange = { it ->
            onPhoneChanged(it.take(mask.count { it == maskNumber }))
        },
        label = {
            Text(
                text = label,
                fontFamily = sanFrancisco,
                color = Color(0xFFA9ABB7)
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        visualTransformation = PhoneVisualTransformation(mask, maskNumber),
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            containerColor = Color(0xFFF6F6F9),
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        maxLines = 1
    )
}

class PhoneVisualTransformation(val mask: String, val maskNumber: Char) : VisualTransformation {

    private val maxLength = mask.count { it == maskNumber }

    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = if (text.length > maxLength) text.take(maxLength) else text

        val annotatedString = buildAnnotatedString {
            if (trimmed.isEmpty()) return@buildAnnotatedString

            var maskIndex = 0
            var textIndex = 0
            while (textIndex < trimmed.length && maskIndex < mask.length) {
                if (mask[maskIndex] != maskNumber) {
                    val nextDigitIndex = mask.indexOf(maskNumber, maskIndex)
                    append(mask.substring(maskIndex, nextDigitIndex))
                    maskIndex = nextDigitIndex
                }
                append(trimmed[textIndex++])
                maskIndex++
            }
        }

        return TransformedText(annotatedString, PhoneOffsetMapper(mask, maskNumber))
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PhoneVisualTransformation) return false
        if (mask != other.mask) return false
        if (maskNumber != other.maskNumber) return false
        return true
    }

    override fun hashCode(): Int {
        return mask.hashCode()
    }
}

private class PhoneOffsetMapper(val mask: String, val numberChar: Char) : OffsetMapping {

    override fun originalToTransformed(offset: Int): Int {
        var noneDigitCount = 0
        var i = 0
        while (i < offset + noneDigitCount) {
            if (mask[i++] != numberChar) noneDigitCount++
        }
        return offset + noneDigitCount
    }

    override fun transformedToOriginal(offset: Int): Int =
        offset - mask.take(offset).count { it != numberChar }
}