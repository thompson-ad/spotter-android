package dev.aaron.thompson.spotter

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchRecentLiftsBar() {
    TextField(
        value = "Search",
        onValueChange = {
            // do something
        },
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun SearchRecentLiftsBarPreview() {
    SearchRecentLiftsBar()
}