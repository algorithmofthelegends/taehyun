package BaekJoon.A24508

fun main() {
    println(test("2 2 1", "1 1")) // YES
    println(test("3 5 2", "1 2 2")) // NO
    println(test("3 5 3", "1 2 2")) // YES
    println(test("3 3 100000", "2 1 2")) // NO
}

private fun test(s1: String, s2: String): String {
    var (n, k, t) = s1.split(" ").map { it.toInt() }
    val v = s2.split(" ").map { it.toInt() }.sortedDescending().toMutableList()
    println(v)
    var m = v.size - 1
    for (i in v.indices) {
        while (v[i] < k && m > i) {
            if (v[m] > 0) {
                if (t > 0) {
                    v[m] -= 1
                    v[i] += 1
                    t -= 1
                } else {
                    return "NO"
                }
            } else {
                m -= 1
            }
        }
    }
    println(v)
    return if (v.any { it != 0 && it != k }) "NO" else "YES"
}