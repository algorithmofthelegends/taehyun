package A14002

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() }
    val dp = IntArray(n) { 1 }

    for (i in a.indices) {
        for (j in 0 until i) {
            if (a[j] < a[i]) {
                dp[i] = maxOf(dp[j]+1, dp[i])
            }
        }
    }

    println(dp.joinToString(" "))

    println(dp.maxOrNull())

    val answer = mutableListOf<Int>()
    var len = dp.maxOrNull()

    for (i in n-1 downTo 0) {
        if (dp[i] == len) {
            answer.add(a[i])
            len--
        }
    }

    println(answer.reversed().joinToString(" "))

    br.close()
}