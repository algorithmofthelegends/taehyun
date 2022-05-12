package BaekJoon.A11562

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val arr = Array(n) { 0 }

    for (i in 0 until n)
        arr[i] = 1 shl i
    for (i in 0 until m) {
        val l = readLine()!!.split(" ").map { it.toInt() }
        arr[l[0] - 1] += 1 shl (l[1] - 1)
        if (l[2] == 1)
            arr[l[1] - 1] += 1 shl (l[0] - 1)
    }

    val k = readLine()!!.toInt()
    val arr2 = Array(k) { 0 }
    for (i in 0 until k) {
        val (f, b) = readLine()!!.split(" ").map { it.toInt() }
        arr2[i] = move(f, b, arr)
    }
    arr2.forEach { println(it) }
}

private fun move(n: Int, m: Int, arr: Array<Int>, c: Int = 0): Int {
    return if (n < m) {
        move(n + 1, m, arr, c + if (arr[n - 1].and(1 shl n) > 0) 0 else 1)
    } else if (n > m) {
        move(n - 1, m, arr, c + if (arr[n - 1].and(1 shl n - 2) > 0) 0 else 1)
    } else {
        c
    }
}