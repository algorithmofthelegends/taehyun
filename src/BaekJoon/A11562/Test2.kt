package BaekJoon.A11562

private var arr: Array<Int> = emptyArray()

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    arr = Array(n + 1) { 0 }

    for (i in 1..n)
        arr[i] = 1 shl (i - 1)
    for (i in 1..m) {
        val l = readLine()!!.split(" ").map { it.toInt() }
        arr[l[0]] += 1 shl l[1] - 1
        if (l[2] == 1)
            arr[l[1]] += 1 shl l[0] - 1
    }

    val k = readLine()!!.toInt()
    val arr2 = Array(k) { 0 }
    arr.forEach { println(Integer.toBinaryString(it).padStart(4, '0')) }
    for (i in 0 until k) {
        val (f, b) = readLine()!!.split(" ").map { it.toInt() }
        println("===========")
        arr2[i] = move(f, b, n, 0)
        println("===========")
    }

    arr2.forEach { println(it) }
}

private fun move(a: Int, b: Int, n: Int, c: Int): Int {
    println("n : m = $a $b $c")
    return if (a == b) {
        c
    } else {
        var min = n
        val chars = Integer.toBinaryString(arr[a])
            .padStart(n, '0')
            .toCharArray()

        // 1 4
        if (a < b) {
            if (a and (1 shl a - 1) > 0) {
                min = move(a + 1, b, n, c + 1)
            } else {
                for (i in a..b) {
                    if (chars[n - i] == '1') {
                        val m = move(n - i + 1, b, n, c)
                        // println("$i $b $c $m $min")
                        if (min > m) {
                            min = m
                        }
                    }
                }
            }
        } else {
            if (a and (1 shl a - 1) > 0) {
                min = move(a - 1, b, n, c + 1)
            } else {
                for (i in a downTo b) {
                    if (chars[n - i] == '1') {
                        val m = move(n - i - 1, b, n, c)
                        println("$i $b $c $m $min")
                        if (min > m) {
                            min = m
                        }
                    }
                }
            }
        }

        min
    }
}

// 0011
// 0110
// 1110
// 1000