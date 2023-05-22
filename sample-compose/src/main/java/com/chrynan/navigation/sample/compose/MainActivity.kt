package com.chrynan.navigation.sample.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.*
import com.chrynan.navigation.ExperimentalNavigationApi
import com.chrynan.navigation.sample.compose.example.SingleContextSample

class MainActivity : AppCompatActivity() {

    @OptIn(ExperimentalNavigationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                // TODO: Change to desired example: ex: MultipleContextSample
                SingleContextSample()
            }
        }
    }
}
