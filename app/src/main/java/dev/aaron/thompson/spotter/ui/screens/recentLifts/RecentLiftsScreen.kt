package dev.aaron.thompson.spotter.ui.screens.recentLifts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.aaron.thompson.spotter.*
import dev.aaron.thompson.spotter.data.model.Lift
import dev.aaron.thompson.spotter.utils.removeZeroDecimal

@OptIn(
    ExperimentalFoundationApi::class,
    ExperimentalMaterial3Api::class
)
@Composable
fun RecentLiftsScreen(
    groupedLifts: Map<Char, List<Lift>>
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "Recent Lifts",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.displaySmall
                        )
                    },
                    scrollBehavior = scrollBehavior
                )
            },
            bottomBar = {
                BottomAppBar {
                    Spacer(Modifier.weight(1f, true))
                    Box(
                        Modifier
                            .fillMaxHeight()
                            .padding(
                                top = 8.dp,
                                end = 12.dp
                            ),
                        contentAlignment = Alignment.TopStart
                    ) {
                        FloatingActionButton(
                            onClick = { /* do something */ },
                            containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                            elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                        ) {
                            Icon(Icons.Filled.Add, "Add new lift")
                        }
                    }
                }
            },
        ) { padding ->
            Column(modifier = Modifier.padding(padding)) {
                Box(modifier = Modifier.padding(16.dp)) {
                    SearchRecentLiftsBar()
                }
                if (groupedLifts != null) {
                    LazyColumn {
                        groupedLifts.forEach { (liftChar, liftsForChar) ->
                            stickyHeader {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(MaterialTheme.colorScheme.primaryContainer)
                                        .padding(
                                            start = 16.dp, top = 2.dp, end = 2.dp, bottom = 2.dp
                                        )
                                ) {
                                    Text(text = liftChar.toString())
                                }
                            }
                            items(liftsForChar) { lift ->
                                val repText = if (lift.reps != 1) "reps" else "rep"
                                ListItem(modifier = Modifier.padding(vertical = 16.dp), headlineText = {
                                    Text(lift.movementName)
                                }, supportingText = { Text(lift.completed) }, trailingContent = {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,

                                        ) {
                                        Row(verticalAlignment = Alignment.Bottom) {
                                            removeZeroDecimal(lift.weight)?.let {
                                                Text(
                                                    text = it,
                                                    style = MaterialTheme.typography.headlineMedium
                                                )
                                            }
                                            Text(
                                                text = "kg",
                                                style = MaterialTheme.typography.bodySmall
                                            )
                                        }
                                        Row(
                                            verticalAlignment = Alignment.Bottom,
                                            modifier = Modifier.padding(horizontal = 6.dp)
                                        ) {
                                            Text(
                                                text = lift.reps.toString(),
                                                style = MaterialTheme.typography.headlineMedium
                                            )
                                            Text(
                                                text = repText,
                                                style = MaterialTheme.typography.bodySmall
                                            )
                                        }
                                        Surface(
                                            modifier = Modifier.size(width = 20.dp, height = 20.dp),
                                            shape = MaterialTheme.shapes.extraSmall,
                                            color = MaterialTheme.colorScheme.primary
                                        ) {}
                                    }
                                })
                                Divider()
                            }
                        }
                    }
                }
            }
        }
    }
}