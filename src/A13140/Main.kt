package A13140

fun main() {
    val str = readLine()!!
    val input = str.toInt();
    val ints = str.toCharArray().map { it.toString().toInt() }.toList().reversed()
    val result = arrayOf(
        arrayOf('h', 'e', 'l', 'l', 'o'),
        arrayOf('w', 'o', 'r', 'l', 'd'),
    )
    val chars = result.flatten().distinct().associateWith { 0 }.toMutableMap()

    for (o in 0..9) {
        for (d in 0..9) {
            if ((o + d) % 10 == ints[0]) {
                var l: Int
                // 홀수인 경우
                if (ints[1] % 2 > 0) {
                    if (o + d > 10) {
                        l = ints[1] / 2
                    } else continue
                } else {
                    l = ints[1] / 2
                }

                for (r in 0..9) {
                    if ((r + l) % 10 == ints[2]) {
                        for (e in 0..9) {
                            if ((e + o) % 10 == ints[3]) {
                                for (h in 1..9) {
                                    for (w in 1..9) {
                                        if ((h + w) % 10 == ints[4]) {
                                            chars['o'] = o
                                            chars['d'] = d
                                            chars['l'] = l
                                            chars['r'] = r
                                            chars['e'] = e
                                            chars['h'] = h
                                            chars['w'] = w

                                            val total = toInt(result, chars)
                                            if (total.sum() == input) {
                                                out(total)
                                                return
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    print("No Answer")
}

private fun toInt(result: Array<Array<Char>>, chars: Map<Char, Int>): List<Int> {
    val list = mutableListOf<Int>()
    result.forEachIndexed { _, f ->
        list.add(f.map { chars[it] }.joinToString("").toInt())
    }
    return list
}

private fun out(list: List<Int>) {
    var sum = 0
    val out = list.foldIndexed("") { idx, acc, v ->
        sum += v
        acc + (if (idx == 0) "  " else "\n+ ") + v
    } + "\n-------\n  $sum\n";
    print(out)
}