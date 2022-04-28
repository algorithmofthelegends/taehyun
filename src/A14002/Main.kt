package A14002

fun main() {
    val n = readLine()!!.toInt()
    val v = ("0 " + readLine()).split(" ").map { it.toInt() }
    val d = Array(n + 1) { 0 }

    for (i in 1..n) {
        var m = d.maxOf { it }
        do {
            for (j in d.indices) {
                if (d[j] == m && v[i] > v[j]) {
                    d[i] = m + 1
                    m = -1
                    break
                }
            }
            m -= 1
        } while (m >= 0)
    }

    val m = d.maxOf { it }
    var i = n + 1
    val r = Array(m) { 0 }
    for (j in m downTo 1) {
        for (k in n downTo 0) {
            if (d[k] == j && k < i) {
                i = k
                r[j - 1] = v[k]
                break
            }
        }
    }
    println(d.maxOf { it })
    print(r.joinToString(" "))
}