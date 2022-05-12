package BaekJoon.A13140

fun main() {
    val str = "66971"
    val input = str.toInt();
    val ints = str.toCharArray().map { it.toString().toInt() }.toList().reversed()
    val result = arrayOf(
        arrayOf('h', 'e', 'l', 'l', 'o'),
        arrayOf('w', 'o', 'r', 'l', 'd'),
    )
    val chars = result.flatten().distinct().associateWith { 0 }.toMutableMap()


    //    --334
    //    -4637

    //    12334
    //    54637

    for (o in 0..9) {
        for (d in 0..9) {

            // o, d 의 1의 자리가 입력값의 1의 자리와 같은지 비교
            // 66971
            // ----(0)
            // -(0)--(1)
            // ...
            // ----(2)
            // -(2)--(9)
            if ((o + d) % 10 == ints[0]) {
                var l: Int
                // ㅣ은 입력값 10의 자리의 / 2 값 입니다
                // 홀수 일 경우 1의자리에서 올림이 일어나야 합니다
                // 66971
                // --(3)(3)2
                // -2-(3)9
                if (ints[1] % 2 > 0) {
                    // 이전 숫자의 합에서 올림이 있을 경우
                    if (o + d > 10) {
                        l = ints[1] / 2
                    } else continue
                } else {
                    l = ints[1] / 2
                }

                for (r in 0..9) {
                    // 나온 l 값을 토대로 r 설정
                    // 66971
                    // --332
                    // -2(6)39
                    if ((r + l) % 10 == ints[2]) {
                        for (e in 0..9) {
                            // 나온 o 값을 토대로 e 설정
                            // 66971
                            // -(4)332
                            // -2639
                            if ((e + o) % 10 == ints[3]) {
                                // h 와 w 는 1 부터 시작
                                for (h in 1..9) {
                                    for (w in 1..9) {
                                        // 66971
                                        // 14332
                                        // 52639

                                        if ((h + w) % 10 == ints[4]) {
                                            chars['o'] = o
                                            chars['d'] = d
                                            chars['l'] = l
                                            chars['r'] = r
                                            chars['e'] = e
                                            chars['h'] = h
                                            chars['w'] = w

                                            // 더하는 두 숫자를 저장 합니다
                                            // hello, world
                                            val total = mutableListOf<Int>()
                                            result.forEachIndexed { _, f ->
                                                total.add(f.map { chars[it] }.joinToString("").toInt())
                                            }
                                            // hello, world 를 더한 값이 입력 값과 같을 경우 결과값 출력
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

// 결과를 출력 합니다
private fun out(list: List<Int>) {
    var sum = 0
    val out = list.foldIndexed("") { idx, acc, v ->
        sum += v
        acc + (if (idx == 0) "  " else "\n+ ") + v
    } + "\n-------\n  $sum\n";
    print(out)
}