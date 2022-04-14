package A20499

fun main() {
    val input = readLine()!!.split("/").map { it.toInt() }
    print(if (input[0] + input[2] < input[1] || input[1] == 0) "hasu" else "gosu")
}