package BaekJoon.A1076

val r = arrayOf(
    "black",
    "brown",
    "red",
    "orange",
    "yellow",
    "green",
    "blue",
    "violet",
    "grey",
    "white",
)

fun main() {
    val s = fun() = r.indexOf(readLine()!!)
    val a = s() * 10 + s()
    print(if (a > 0) "$a" + "0".repeat(s()) else a)
}