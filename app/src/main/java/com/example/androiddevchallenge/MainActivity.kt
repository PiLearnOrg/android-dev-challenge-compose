/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.PaaTheme

class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaaTheme {
                OverviewScreen()
            }
        }
    }
}

@Composable
fun PuppyItem(puppy: Puppy) {
    val context = LocalContext.current
    Card(
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                val intent = Intent(context, PuppyActivity::class.java)
                intent.putExtra("puppyID", puppy.id)
                context.startActivity(intent)
            }
    ) {
        Column {
            Box(
                Modifier
                    .background(Color.Gray)
                    .padding(8.dp)
            ) {
                Text(puppy.name)
            }
            Image(
                painter = painterResource(id = puppy.picture),
                contentDescription = "Puppy picture"
            )
        }
    }
}

@Preview
@Composable
fun PuppyItemPreview() {
    PuppyItem(puppy = puppies[0])
}

// Start building your app here!
@ExperimentalFoundationApi
@Composable
fun OverviewScreen() {
    Surface(color = MaterialTheme.colors.background) {
        LazyVerticalGrid(cells = GridCells.Fixed(2)) {
            items(puppies) {
                PuppyItem(puppy = it)
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    PaaTheme {
        OverviewScreen()
    }
}

//@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@ExperimentalFoundationApi
@Composable
fun DarkPreview() {
    PaaTheme(darkTheme = true) {
        OverviewScreen()
    }
}
