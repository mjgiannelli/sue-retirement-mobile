package com.markgiannelli.sue_retirement_mobile.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.format.DateTimeFormatter

@Composable
fun BibleVerseCard(
    state: BibleVerseState,
    modifier: Modifier = Modifier
) {
    state.bibleVerseInfo?.bibleVerseData?.let { data ->
        Column(
            modifier = Modifier
                .fillMaxWidth(),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                shape = RectangleShape,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.Black)
                ) {
                    Text(
                        text = "Verse of the day \uD83D\uDE07",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color(255, 182, 193),
                        modifier = Modifier.padding(16.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }
            Row(
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(
                    text = data.bookname,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
                Text(
                    text = " ${data.chapter}",
                    fontWeight = FontWeight.Bold,
                    color = Color.Red,
                    fontSize = 25.sp
                )
                Text(
                    text = " : ",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 25.sp
                )
                Text(
                    text = data.verse,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF006400),
                    fontSize = 25.sp
                )
            }
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = data.text,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}