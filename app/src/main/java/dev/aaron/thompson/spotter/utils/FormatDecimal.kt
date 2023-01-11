package dev.aaron.thompson.spotter.utils

fun removeZeroDecimal(d: Double): String? {
    return if (d == d.toLong().toDouble()) String.format("%d", d.toLong()) else String.format(
        "%s", d
    )
}