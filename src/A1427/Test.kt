package A1427

fun main() {
    val input = "999998999".toCharArray().map { it.digitToInt() }.sortedDescending().toIntArray()
    input.forEach { print(it) }
}