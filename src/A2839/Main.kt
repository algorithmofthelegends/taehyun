package A2839

fun main() {
    val n = readLine()!!.toInt()
    for (i in n / 5 downTo 0)
        if ((n - i * 5) % 3 == 0) {
            print(i + (n - i * 5) / 3)
            return
        }
    print(-1)
}