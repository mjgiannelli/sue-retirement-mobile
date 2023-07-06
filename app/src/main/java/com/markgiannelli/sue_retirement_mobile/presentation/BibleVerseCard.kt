package com.markgiannelli.sue_retirement_mobile.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.time.format.DateTimeFormatter

@Composable
fun BibleVerseCard(
    state: BibleVerseState,
    modifier: Modifier = Modifier
) {
    state.bibleVerseInfo?.bibleVerseData?.let { data ->
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Today ${
                        data.bookname
                    }",
                    modifier = Modifier.align(Alignment.End),
                    color = Color.White
                )
            }
        }
    }
}