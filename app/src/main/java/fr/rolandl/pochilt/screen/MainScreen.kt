package fr.rolandl.pochilt.screen

import android.widget.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MainScreen(
  onClick: () -> Unit
) {
  ElevatedButton(
    onClick = onClick
  ) {
    Text("Click")
  }
}