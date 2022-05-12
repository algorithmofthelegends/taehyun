package BaekJoon.A1334

import kotlin.math.pow

fun main() {
    var n: String
    n = "12345"
    n = "1999"
    n = "2"
    n = "54"
    n = "45"
    n = "201"
    n = "54321"
    n = "100"
    n = "1"
    n = "11"
    n = "9"
    n = "99999999999999999999999999999999999999999999999999"
    n = "3999993"
    val result = if (n.length == 1 && n.toInt() < 9)
        n.toInt() + 1
    else {
        // 길이
        val l = n.length
        // 가운데 위치
        val h = l / 2
        // 홀수 여부
        val o = l % 2
        // 올림 값
        var carry = 0

        var front = n.slice(IntRange(0, h - 1))
        var back = n.slice(IntRange(h + o, l - 1))
        var mid = n.slice(IntRange(h, h + o - 1))

        println("h : $h")
        println("front : $front")
        println("mid : $mid")
        println("back : $back")

        // 앞을 뒤짚은 값이 뒤 보다 작을 경우
        if (sum(front.reversed()) <= sum(back)) {
            // 앞 + 중간 을 배열로 만듭니다
            val arr = (front + mid).toCharArray().map { it.digitToInt() }.toMutableList()
            // 위 배열에서 + 1 합니다
            // 자리 올림이 생겼을 경우 다음 수 에도 +1
            for (i in arr.size - 1 downTo 0) {
                val temp = arr[i] + 1
                arr[i] = temp % 10
                carry = temp / 10
                if (carry == 0) break;
            }

            // 홀수 인 경우
            // 앞+중간 에서 중간 값을 다시 복구 합니다
            if (o == 1) {
                mid = arr[arr.size - 1].toString()
                arr.removeAt(arr.size - 1)
            }

            // 올림이 있는 경우
            // 중간 값에 올림이 일어난 수를 추가 합니다
            if (carry == 1) {
                mid += arr[arr.size - 1].toString()
                arr.removeAt(arr.size - 1)
            }

            // 맨 앞 숫자에도 자리 올림이 있다면 1을 추가 합니다
            // ex. 99 -> 100
            front = (if (carry == 1) "1" else "") + arr.joinToString("")
        }

        front + mid + front.reversed()
    }
    print(result)
}

private fun sum(s: String): Int = s.toCharArray().mapIndexed { i, c -> c.digitToInt() * 10.0.pow(i) }.sum().toInt()