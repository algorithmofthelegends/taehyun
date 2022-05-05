package A1577

fun main() {
    val (n, m) = arrayOf(7, 7)
    val k = 2
    val l = Array(m) {
        Array(n) {
            0
        }
    }
    val t = arrayOf(
        arrayOf(0, 0, 0, 1),
        arrayOf(6, 6, 5, 6)
    )

    for (i in 0 until k) {
        val (a, b, c, d) = t[i]
        l[a][b] = 1
        l[c][d] = 1
    }

    print(l.contentDeepToString())

//  - - 0 0 0 0
//  0 0 0 0 0 0
//  0 0 0 0 0 0
//  0 0 0 0 0 0
//  0 0 0 0 0 -
//  0 0 0 0 0 -
}