package A1264

fun main() {
    val m = arrayOf('a', 'e', 'i', 'o', 'u');
    while (true) {
        val input = readLine()!!
        if (input != "#") {
            println(input.toCharArray().filter { m.contains(it.lowercaseChar()) }.size)
        } else {
            break
        }
    }
}