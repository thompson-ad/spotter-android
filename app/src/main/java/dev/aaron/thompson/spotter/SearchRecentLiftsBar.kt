package dev.aaron.thompson.spotter

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchRecentLiftsBar() {
    var query: String by rememberSaveable { mutableStateOf("") }
    var showClearQueryIcon: Boolean by rememberSaveable { mutableStateOf(false) }

    TextField(
        value = query,
        onValueChange = { onQueryChanged ->
            // If user makes changes to text, immediately updated it.
            query = onQueryChanged
            // To avoid crash, only query when string isn't empty.
            // if (onQueryChanged.isNotEmpty()) {
            // Pass latest query to refresh search results.
            // viewModel.performQuery(onQueryChanged)
            //}
        },
        leadingIcon = {
            IconButton(
                modifier = Modifier.padding(start = 4.dp),
                onClick = {
//                    closeKeyboardAndNavigateUp(
//                        navigateUp = navigateUp,
//                        closeKeyboard = closeKeyboard,
//                        keyboardState = keyboardState
//                    )
                }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    tint = MaterialTheme.colorScheme.onBackground,
                    contentDescription = "Search"
                )
            }
        },
        trailingIcon = {
            if (showClearQueryIcon) {
                IconButton(
                    onClick = {
                        query = ""
                        // closeKeyboard()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Clear,
                        tint = MaterialTheme.colorScheme.onBackground,
                        contentDescription = "clear"
                    )
                }
            }
        },
        placeholder = { Text(text = "Search...") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
        maxLines = 1,
        modifier = Modifier
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}


@Preview(showBackground = true)
@Composable
fun SearchRecentLiftsBarPreview() {
    SearchRecentLiftsBar()
}