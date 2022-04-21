package A1009

fun main() {
    val a = 99
    val b = 4
    var m = 1
    for (i in 1..b) {
        m *= a
        print("$m".last().digitToInt())
        print(" : $m")
        println()
    }
}