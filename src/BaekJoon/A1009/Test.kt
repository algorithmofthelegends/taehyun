package BaekJoon.A1009

fun main() {
    val t = readLine()!!.toInt()
    val toInt = fun(s: Int) = "$s".last().digitToInt()
    for (i in 1..t) {
        var (a, b) = readLine()!!.split(" ").map { it.toInt() }
        a = toInt(a)
        var m = 1
        val l = Array(4) {
            m *= a
            toInt(m)
        }
        println(l.contentDeepToString())
        var j = b % 4 - 1
        j = if (j > -1) j else 3
        println(
            if (l[j] == 0) 10
            else l[j]
        )
    }
}