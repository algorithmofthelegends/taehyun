package A2343

fun main() {
    val start = System.currentTimeMillis()
    val size = 3
    val last = 9
    val list = arrayListOf<Int>()
    for (i in 1..last)
        list.add(i)
    val cnt = list.count()

    var init = 1
    while (list.slice(IntRange(0, init)).sum() < list.last()) {
        init++
    }

    val temp = Array(size) { init }
    var min = temp
    for (i in 1 until size)
        temp[i] = 1
    temp[size - 1] = cnt - size - init

    val fnc = fun(list: List<Int>, temp: Array<Int>): Int {
        var max = 0
        var idx = 0
        temp.forEach {
            val sum = list.slice(IntRange(idx, idx + it - 1)).sum()
            max = if (max > sum) max else sum
            idx += it
        }
        return max
    }

    var result = fnc(list, temp)
    var i = size - 1;

    while (temp[0] < cnt - size + 1) {
        if (temp[i] == 1) {
            i--
            if (i < size - 1 && temp[i] != 1) {
                val carry = temp[i] - 1
                temp[i - 1] += 1
                for (j in i until size) {
                    temp[j] = 1
                }
                temp[size - 1] = carry
                i = size - 1
            }
        } else {
            temp[i] -= 1
            temp[i - 1] += 1
        }
        val v = fnc(list, temp)
        if (result > v) {
            result = v
            min = temp.clone()
        }
    }

    println(result)
    println(min.contentDeepToString())
    println(System.currentTimeMillis() - start)
    // 1000 22931 -> 1128, 167164
    // 10000 22931 ->
}