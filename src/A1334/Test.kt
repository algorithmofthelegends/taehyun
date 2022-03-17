package A1334

fun main() {
    val input = "1234567890123456789"
    val result = if (input.length == 1) {
        input.toInt() + 1
    } else {
        execute(input)
    }
    print(result)
}

private fun execute(s: String): String {
    val l = s.length;
    val odd = l % 2;
    val half = l / 2;

    val front = s.slice(IntRange(0, half - 1))
    var back = s.slice(IntRange(half + odd, l - 1))

    if (front.first() > back.first()) {
        back = front.reversed()
    } else {
        return execute(inc(s))
    }

    return if (odd == 1) {
        front + s.slice(IntRange(half, half)) + back
    } else {
        front + back
    }
}

private fun inc(s: String): String {
    val arr = s.toCharArray().map { it.digitToInt() }.toMutableList()
    var carry = 1
    for (i in arr.size - 1 downTo 0) {
        val temp = arr[i] + carry
        arr[i] = temp % 10
        carry = temp / 10
        if (carry == 0) break;
    }
    println(arr.toString())
    return arr.joinToString("")
}