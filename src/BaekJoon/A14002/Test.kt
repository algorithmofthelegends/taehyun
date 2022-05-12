package BaekJoon.A14002

fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }
    val v = arr.toMutableList()
    val r = Array(n) { it }

    for (i in 0 until n)
        for (j in 0 until n)
            if (v[i] < v[j]) {
                val t = v[i]
                v[i] = v[j]
                v[j] = t
                val idx = r[i]
                r[i] = r[j]
                r[j] = idx
            }

    val f = fun(i: Int): ArrayList<Int> {
        val l = ArrayList<Int>()
        var tmp = i
        l.add(r[tmp])
        for (j in i until n) {
            if (r[tmp] < r[j]) {
                l.add(r[j])
                tmp = j
            }
        }
        return l
    }

    var max = 0
    var l = ArrayList<Int>()
    for (i in 0 until n) {
        val tmp = f(i)
        if (max < tmp.size || max == tmp.size && l[0] < tmp[0]) {
            max = tmp.size
            l = tmp
        }
    }

    println(max)
    print(l.map { arr[it] }.joinToString(" "))
}