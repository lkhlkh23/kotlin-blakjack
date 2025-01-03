package blackjack.util

import java.lang.IllegalArgumentException

fun format(values: List<String>): String {
    if (values.isEmpty()) {
        throw IllegalArgumentException()
    }

    return values.joinToString(",")
}
