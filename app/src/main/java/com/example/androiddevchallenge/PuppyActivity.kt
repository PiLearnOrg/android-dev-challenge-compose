package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.androiddevchallenge.ui.theme.PaaTheme

class PuppyActivity : AppCompatActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.extras?.getInt("puppyID") ?: 0
        val puppy = puppies[id]
        setContent {
            PaaTheme {
                PuppyScreen(puppy = puppy)
            }
        }
    }
}

@Composable
fun PuppyScreen(puppy: Puppy) {
    Card(
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(8.dp)
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
fun PuppyScreenPreview() {
    PuppyScreen(puppy = puppies[0])
}
