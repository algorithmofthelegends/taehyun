package BaekJoon.A2839

fun main() {
    val n = readLine()!!.toInt()
    val m = 1000
    for (i in n / 5 downTo 0)
        for (j in 0..m)
            if (i * 5 + j * 3 == n) {
                print(i + j)
                return
            }
    print(-1)
}