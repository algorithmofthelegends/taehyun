package BaekJoon.A1026

fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }.sorted()
    val b = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
    var result = 0

    for (i in 0 until n) {
        var idx = 0;
        for (y in b.indices) {
            if (b[y] > b[idx]) {
                idx = y
            }
        }

        result += a[i] * b[idx]
        b[idx] = -1
    }
    print(result)
}