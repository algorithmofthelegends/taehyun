package A1418

fun main() {
    val n = readLine()!!.toInt()
    val k = readLine()!!.toInt()
    val r = ArrayList<Int>()
    for (i in 2..n) {
        val l = ArrayList<Int>()
        var t = i
        while (t != 1) {
            for (j in 2..t) {
                if (t % j == 0) {
                    t /= j
                    l.add(j)
                    break
                }
            }
        }
        r.add(l.maxOf { it })
    }
    print(r.count { k >= it } + 1)
}