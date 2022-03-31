package A1015

fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
    val r = Array(n) { 0 }

    // 배열 arr 을 정렬 후 결과 배열 r 에 순차적으로 기존 index 에 정렬한 index 를 대입합니다
    arr.sorted().forEachIndexed { idx, i ->
        val ai = arr.indexOf(i)
        arr[ai] = -1
        r[ai] = idx
    }
    print(r.joinToString(" "))
}