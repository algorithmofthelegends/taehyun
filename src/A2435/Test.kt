package A2435

fun main() {
    val r = fun() = readLine()!!.split(" ").map { it.toInt() }
    val (c, d) = r()
    val l = r()
    var max = 0
    for (i in 0..c - d) {
        var sum = 0
        for (j in i until i + d)
            sum += l[j]
        max = if (max < sum) sum else max
    }
    print(max)
}