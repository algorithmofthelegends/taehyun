package A1026

fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
    val b = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
    var result = 0

    for (i in 1..n) {
        var idxA = 0;
        for (x in a.indices) {
            if (a[x] < a[idxA]) {
                idxA = x
            }
        }

        var idxB = 0;
        for (y in b.indices) {
            if (b[y] > b[idxB]) {
                idxB = y
            }
        }

        result += a[idxA] * b[idxB]
        a[idxA] = 101
        b[idxB] = -1
    }
    print(result)
}