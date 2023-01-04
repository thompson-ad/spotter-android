package dev.aaron.thompson.spotter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.aaron.thompson.spotter.ui.theme.SpotterTheme

data class Lift(
    val movementName: String,
    val completed: String,
    val weight: Double,
    val reps: Int,
    val exertion: String
)

val lifts = listOf(
    Lift(movementName = "Alternating DB Hammer Curl", completed = "3 weeks ago", weight = 18.5, reps = 10, exertion = "max"),
    Lift(movementName = "Back Squat", completed = "3 days ago", weight = 100.0, reps = 4, exertion = "max"),
    Lift(movementName = "Barbell Bench Press", completed = "4 days ago", weight = 80.25, reps = 6, exertion = "easy"),
    Lift(movementName = "Barbell Incline Bench Press", completed = "2 weeks ago", weight = 60.0, reps = 6, exertion = "hard"),
    Lift(movementName = "DB Lateral Squat", completed = "last month", weight = 12.5, reps = 12, exertion = "easy"),
    Lift(movementName = "Deadlift", completed = "last month", weight = 110.0, reps = 2, exertion = "max"),
)

fun fmt(d: Double): String? {
    return if (d == d.toLong().toDouble()) String.format("%d", d.toLong()) else String.format("%s", d)
}

val groupedLifts = lifts.groupBy { it.movementName[0] }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpotterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    SpotrApp(groupedLifts = groupedLifts)
                }
            }
        }
    }
}

@OptIn(
    ExperimentalFoundationApi::class,
    ExperimentalMaterial3Api::class
)
@Composable
fun SpotrApp(groupedLifts: Map<Char, List<Lift>>) {
 Scaffold(
     topBar = {TopAppBar(title = {Text("Recent Lifts")})},
     floatingActionButton = {
         FloatingActionButton(onClick = { /* ... */ }) {
             /* FAB content */
         }
     }
 ) { paddingValues ->
     if (groupedLifts != null) {
         LazyColumn(modifier = Modifier.padding(paddingValues)) {
             groupedLifts.forEach { (liftChar, liftsForChar) ->
                 stickyHeader {
                     Text(text = liftChar.toString())
                 }
                 items(liftsForChar) { lift ->
                     ListItem(
                         headlineText = {
                             Text(lift.movementName)
                                        },
                         supportingText = { Text(lift.completed) },
                         trailingContent = {
                             Row(
                                 verticalAlignment = Alignment.CenterVertically,

                             ) {
                                 Row(verticalAlignment = Alignment.Bottom) {
                                     fmt(lift.weight)?.let { Text(text = it, style = MaterialTheme.typography.headlineMedium) }
                                     Text(text = "kg", style = MaterialTheme.typography.bodySmall)
                                 }
                                 Row(verticalAlignment = Alignment.Bottom, modifier = Modifier.padding(horizontal = 6.dp)) {
                                     Text(text = lift.reps.toString(), style = MaterialTheme.typography.headlineMedium)
                                     Text(text = "reps", style = MaterialTheme.typography.bodySmall)
                                 }
                                 Surface(
                                     modifier = Modifier.size(width = 20.dp, height = 20.dp),
                                     shape = MaterialTheme.shapes.extraSmall,
                                     color = MaterialTheme.colorScheme.primary
                                 ){}
                             }
                         }
                     )
                     Divider()
                 }
             }
         }
     }
 }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SpotterTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            SpotrApp(groupedLifts = groupedLifts)
        }
    }
}