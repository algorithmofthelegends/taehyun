package BaekJoon.A13333

fun main() {
    val n = readLine()!!.toInt()
    val l = readLine()!!.split(" ").map { it.toInt() }
    var r = 0
    for (k in n downTo 0)
        if (l.count { it >= k } >= k) {
            r = k
            break
        }
    print(r)
}