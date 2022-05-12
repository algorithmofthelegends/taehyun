package BaekJoon.A1153

fun main() {
    val n = readLine()!!.toInt()
    val r = List(n - 2) { it + 2 }
        .filter {
            var r = true
            for (i in 2..Math.sqrt(it.toDouble()).toInt())
                if (it % i == 0) {
                    r = false
                    break
                }
            r
        }

    if (n < 8)
        print(-1)
    else if (n % 2 == 0) {
        print("2 2")
        goldbach(n - 4, r)
    } else {
        print("2 3")
        goldbach(n - 5, r)
    }
}

private fun goldbach(n: Int, r: List<Int>) {
    for (a in r)
        for (b in r)
            if (n == a + b) {
                print(" $a $b")
                return
            } else if (n < a + b) {
                break
            }
}