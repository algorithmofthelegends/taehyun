package BaekJoon.A2609

import kotlin.math.pow

fun main() {
    val (n, m) = arrayOf(24, 18).map { measure(it) }
//    {2=[2, 2, 2], 3=[3]}
    println(n)
//    {2=[2], 3=[3, 3]}
    println(m)
    println(gcd(n, m))
    print(lcm(n, m))
}

// n 의 소수와 그 갯수를 구합니다
// ex) {2=[2, 2, 2], 3=[3]} 2 : 3개, 3 : 1개
private fun measure(n: Int): Map<Int, List<Int>> {
    val l = ArrayList<Int>()
    var tmp = n
    do {
        for (i in 2..n) {
            if (tmp % i == 0) {
                l.add(i)
                tmp /= i
                break
            }
        }
    } while (tmp != 1)
    return l.groupBy { it }
}

// 최대공약수는 공통되는 소수와 그 소수의 갯수 중 작은 것의 제곱을 곱합니다
// {2=[2, 2, 2], 3=[3]}
// {2=[2], 3=[3, 3]}
// 위 예시에서는 2와 3이 공통되는 소수이고
// 2의 경우 1개, 3의 경우 1개 를 제곱하여 2 * 3 = 6 이 최대공약수가 됩니다
private fun gcd(n: Map<Int, List<Int>>, m: Map<Int, List<Int>>): Int {
    var r = 1.0
    for (i in n.keys) {
        val f = n[i]?.size ?: 0
        val t = m[i]?.size ?: 0
        r *= i.toDouble().pow(if (t < f) t else f)
    }
    return r.toInt()
}

// 최소공배수는 두 수의 모든 소수와 그 소수의 갯수 중 큰 것의 제곱을 곱합니다
// {2=[2, 2, 2], 3=[3]}
// {2=[2], 3=[3, 3]}
// 위 예시에서는 2와 3이 공통되는 소수이고
// 2의 경우 3개, 3의 경우 2개 를 제곱하여 8 * 9 = 72 이 최소공배수가 됩니다
private fun lcm(n: Map<Int, List<Int>>, m: Map<Int, List<Int>>): Int {
    var r = 1.0
    n.keys.plus(m.keys).forEach {
        val f = n[it]?.size ?: 0
        val t = m[it]?.size ?: 0
        r *= it.toDouble().pow(if (t > f) t else f)
    }
    return r.toInt()
}