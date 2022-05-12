package BaekJoon.A1334

fun main() {
    var n: String
    n = "1119222"
    n = "2229111"
    n = "1239000"
    n = "1009200"
    n = "2009100" //
    n = "3210234" //
    val result = if (n.length == 1) {
        n.toInt() + 1
    } else {
        var front: String
        val b = n.length % 2 + n.length / 2
        if (n.slice(IntRange(0, 0)).toInt() <= n.slice(IntRange(b, b)).toInt()) {
            val arr = n.slice(IntRange(0, b - 1)).toCharArray().map { it.digitToInt() }.toMutableList()
            var carry = 0;
            for (i in arr.size - 1 downTo 0) {
                val temp = arr[i] + 1
                arr[i] = temp % 10
                carry = temp / 10
                if (carry == 0) break;
            }
            front = (if (carry == 1) "1" else "") + arr.joinToString("")
        } else {
            front = n.slice(IntRange(0, b - 1))
        }
        val mid = front.last()
        front = front.dropLast(1)
        front + mid + front.reversed()
    }
    print(result)
}