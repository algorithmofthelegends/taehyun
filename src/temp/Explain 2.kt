package temp

fun main() {
    val input = readLine()!!.split(" ").map{ it.toInt()}
    val cnt = input[0]
    val size = input[1]
    val list = readLine()!!.split(" ").map{ it.toInt()}
    val temp = Array(size) { 0 }

    temp.forEachIndexed { index, i ->
        temp[index] = 1
    }
    temp[size - 1] = cnt - size + 1

    val fnc = fun(list: List<Int>, temp: Array<Int>): Int {
        val cln = list.toMutableList()
        var max = 0
        temp.forEach {
            var sum = 0
            for (i in 0 until it)
                sum += cln.removeFirst()
            max = if (max > sum) max else sum
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
        result = if (result > v) v else result
    }

    print(result)
}