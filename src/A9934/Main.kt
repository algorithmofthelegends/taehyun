package A9934

import java.util.*
import kotlin.math.pow

fun main() = with(Scanner(System.`in`)) {
    val num = 2.0
    val line = nextLine().toInt()
    val last = num.pow(line - 1).toInt()
    val arr = nextLine().split(" ")
    val result = Array(line) { Array(last) { "" } }

    var idx = 1
    arr.forEach {
        for (y in 0 until line) {
            if (idx % num.pow(line - y - 1).toInt() == 0 || y == line - 1) {
                result[y] = result[y].plus(it)
                idx++
                break;
            }
        }
    }
    result.forEach { y ->
        y.forEach { x ->
            if(x != "")
                print("$x ")
        }
        println()
    }
}