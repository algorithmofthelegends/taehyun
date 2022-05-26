package BaekJoon.A1038

fun main() {
    val n = readLine()!!.toInt()
    var len = 2
    val l = ArrayList<Long>()
    (0..9L).forEach { l.add(it) }

    fun insert(i: Long, d: Long, carry: Long) {
        if (d == 0L)
            l.add(carry)
        else
            for (j in d - 1 until i)
                insert(j, d - 1, carry * 10 + j)
    }

    if (n > 9)
        while (l.size < n + 1) {
            if (len > 10)
                break
            for (i in len - 1..9L)
                insert(i, len - 1L, i)
            len++
        }
    print(if (n >= l.size) -1 else l[n])
}