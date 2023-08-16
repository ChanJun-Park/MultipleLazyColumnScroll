package com.example.multiplelazycolumnscroll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.multiplelazycolumnscroll.ui.theme.MultipleLazyColumnScrollTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultipleLazyColumnScrollTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MultipleLazyColumnInColumnTest()
                }
            }
        }
    }
}

@Composable
private fun MultipleLazyColumnInColumnTest() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(
                state = rememberScrollState(),
                flingBehavior = ScrollableDefaults.flingBehavior()
            )
    ) {
        MultiLazyColumnRow()

        val backgroundColorList = listOf(Color.Black, Color.Red, Color.Green, Color.Blue)
        for (index in 0 until 10) {
            // dummy Spacer for making Column scrollable
            Spacer(
                Modifier
                    .background(color = backgroundColorList[index / 4])
                    .fillMaxWidth()
                    .height(100.dp)
            )
        }
    }
}

@Composable
fun MultiLazyColumnRow() {
    Row(
        Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .background(color = Color.Red.copy(alpha = 0.5f))
                .weight(1f)
                .fillMaxHeight()
        ) {
            items(count = 100) {
                Text(
                    text = it.toString()
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .background(color = Color.Green.copy(alpha = 0.5f))
                .weight(1f)
                .fillMaxHeight()
        ) {
            items(count = 100) {
                Text(text = it.toString())
            }
        }

        LazyColumn(
            modifier = Modifier
                .background(color = Color.Blue.copy(alpha = 0.5f))
                .weight(1f)
                .fillMaxHeight()
        ) {
            items(count = 100) {
                Text(text = it.toString())
            }
        }

    }
}