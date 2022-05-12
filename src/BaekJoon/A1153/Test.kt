package BaekJoon.A1153

fun main() {
    val n = readLine()!!.toInt()
    val dr = mutableListOf(2, 3, 5, 7)
    val r = List(n - 2) { it + 2 }
        .filter {
            !dr.any { di -> it % di == 0 }
        }.toMutableList()
    r.addAll(0, dr)
    println(r)
    for (a in r) {
        for (b in r) {
            for (c in r) {
                for (d in r) {
                    if (a + b + c + d == n) {
                        print("$a $b $c $d")
                        return
                    }
                }
            }
        }
    }
    print(-1)
}