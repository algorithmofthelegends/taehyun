package A1612

fun main() {
    val n = 13
    var i = 2
    val chk = fun() = CharArray(i) { '1' }.concatToString().toDouble() % n != 0.0
    if (n % 2 == 0 || n % 5 == 0)
        print(-1)
    else {
        while (chk())
            i += 1
        print(i)
    }
    println()
    println(CharArray(i) { '1' }.concatToString())
    println(CharArray(i) { '1' }.concatToString().toDouble() / n)
}