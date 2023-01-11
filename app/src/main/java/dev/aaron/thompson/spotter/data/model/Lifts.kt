package dev.aaron.thompson.spotter.data.model

data class Lift(
    val movementName: String,
    val completed: String,
    val weight: Double,
    val reps: Int,
    val exertion: String
)

val lifts = listOf(
    Lift(
        movementName = "Alternating DB Hammer Curl",
        completed = "3 weeks ago",
        weight = 18.5,
        reps = 1,
        exertion = "max"
    ),
    Lift(
        movementName = "Back Squat",
        completed = "3 days ago",
        weight = 100.0,
        reps = 4,
        exertion = "max"
    ),
    Lift(
        movementName = "Barbell Bench Press",
        completed = "4 days ago",
        weight = 80.25,
        reps = 6,
        exertion = "easy"
    ),
    Lift(
        movementName = "Barbell Incline Bench Press",
        completed = "2 weeks ago",
        weight = 60.0,
        reps = 6,
        exertion = "hard"
    ),
    Lift(
        movementName = "DB Lateral Squat",
        completed = "last month",
        weight = 12.5,
        reps = 12,
        exertion = "easy"
    ),
    Lift(
        movementName = "Deadlift",
        completed = "last month",
        weight = 110.0,
        reps = 2,
        exertion = "max"
    ),
    Lift(
        movementName = "Alternating DB Hammer Curl",
        completed = "3 weeks ago",
        weight = 18.5,
        reps = 10,
        exertion = "max"
    ),
    Lift(
        movementName = "Back Squat",
        completed = "3 days ago",
        weight = 100.0,
        reps = 4,
        exertion = "max"
    ),
    Lift(
        movementName = "Barbell Bench Press",
        completed = "4 days ago",
        weight = 80.25,
        reps = 6,
        exertion = "easy"
    ),
    Lift(
        movementName = "Barbell Incline Bench Press",
        completed = "2 weeks ago",
        weight = 60.0,
        reps = 6,
        exertion = "hard"
    ),
    Lift(
        movementName = "DB Lateral Squat",
        completed = "last month",
        weight = 12.5,
        reps = 12,
        exertion = "easy"
    ),
    Lift(
        movementName = "Deadlift",
        completed = "last month",
        weight = 110.0,
        reps = 2,
        exertion = "max"
    ),
)