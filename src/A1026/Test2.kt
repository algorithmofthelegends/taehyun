package A1026

fun main() {
    val n = 3
    val a = "1 1 3".split(" ").map { it.toInt() }.sorted()
    val b = "10 30 20".split(" ").map { it.toInt() }.sortedDescending()

    print(a.foldIndexed(0) { index, total, num ->
        total + num * b[index]
    })
}