package BaekJoon.A1612

fun main() {
    val n = readLine()!!.toInt()
    var c = 2
    var i = 11
    print(
        if (n % 2 == 0 || n % 5 == 0)
            -1
        else if (n == 1)
            1
        else {
            while (i % n != 0) {
                i = (i * 10 + 1) % n
                c += 1
            }
            c
        }
    )
}