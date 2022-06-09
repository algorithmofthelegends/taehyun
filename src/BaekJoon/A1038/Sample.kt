package BaekJoon.A1038

fun main() {
    val a = (1 until (1 shl 10)).map { state ->
        (9 downTo 0).filter { (state shr it) and 1 == 1 }.joinToString("").toLong()
    }.sorted()
    val n = readLine()!!.toInt()
    print(if (n < a.size) a[n] else -1)
}