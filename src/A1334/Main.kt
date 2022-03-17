package A1334

import kotlin.math.pow

fun main() {
    val n = readLine()!!
    val result = if (n.length == 1)
        n.toInt() + 1
    else {
        val l = n.length
        val h = l / 2
        val o = l % 2
        var carry = 0

        var front = n.slice(IntRange(0, h - 1))
        var back = n.slice(IntRange(h + o, l - 1))
        var mid = n.slice(IntRange(h, h + o - 1))

        if (sum(front.reversed()) <= sum(back)) {
            val arr = (front + mid).toCharArray().map { it.digitToInt() }.toMutableList()
            for (i in arr.size - 1 downTo 0) {
                val temp = arr[i] + 1
                arr[i] = temp % 10
                carry = temp / 10
                if (carry == 0) break;
            }

            if (o == 1) {
                mid = arr[arr.size - 1].toString()
                arr.removeAt(arr.size - 1)
            }

            if (carry == 1) {
                mid += arr[arr.size - 1].toString()
                arr.removeAt(arr.size - 1)
            }
            front = (if (carry == 1) "1" else "") + arr.joinToString("")
        }

        front + mid + front.reversed()
    }
    print(result)
}

private fun sum(s: String): Int = s.toCharArray().mapIndexed { i, c -> c.digitToInt() * 10.0.pow(i) }.sum().toInt()