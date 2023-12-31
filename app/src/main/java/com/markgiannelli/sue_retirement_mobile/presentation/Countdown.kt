package com.markgiannelli.sue_retirement_mobile.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Countdown(targetDateTime: LocalDateTime) {
    val currentDateTime = LocalDateTime.now()
    var timeLeft by remember { mutableStateOf(Duration.between(currentDateTime, targetDateTime)) }
    var businessDaysLeft by remember { mutableStateOf<Long>(calcNumOfBusinessDaysLeft(targetDateTime.toLocalDate()))}

    LaunchedEffect(key1 = targetDateTime) {
        while (currentDateTime.isBefore(targetDateTime)) {
            timeLeft = Duration.between(LocalDateTime.now(), targetDateTime)
            businessDaysLeft = calcNumOfBusinessDaysLeft(targetDateTime.toLocalDate(), timeLeft.toDays() / 365)
            delay(1000)
        }
    }

    val years = timeLeft.toDays() / 365
    val days = timeLeft.toDays() % 365
    val hours = timeLeft.toHours() % 24
    val minutes = timeLeft.toMinutes() % 60
    val seconds = timeLeft.seconds % 60

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ColumnWithText(value = years, text = "Years")
        ColumnWithText(value = days, text = "Days")
        ColumnWithText(value = hours, text = "Hours")
        ColumnWithText(value = minutes, text = "Minutes")
        ColumnWithText(value = seconds, text = "Seconds")
    }
    Row(modifier = Modifier.padding(32.dp)) {
        Text(
            text = "Working Days Left: ",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Text(
            text = "$businessDaysLeft",
            color = Color(0xFF006400),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
    }
}

@Composable
fun ColumnWithText(value: Long, text: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$value",
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp
        )
        Text(
            text = text,
            fontSize = 20.sp
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun calcNumOfBusinessDaysLeft(targetDate: LocalDate, years: Long = 0): Long {
    val startDate = LocalDate.now()
    var businessDays = 0

    var date = startDate
    while(date.isBefore(targetDate)) {
        if(!(date.dayOfWeek == DayOfWeek.SATURDAY || date.dayOfWeek == DayOfWeek.SUNDAY)) {
            businessDays++
        }
        date = date.plusDays(1)
    }

    // subtract out holidays
    val holidays: Long = years * 14 + 14
    return businessDays - holidays
}
