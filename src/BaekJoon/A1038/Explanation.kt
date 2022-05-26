package BaekJoon.A1038

fun main() {
    val n = readLine()!!.toInt()
    // 정수 길이
    var len = 2
    // 감소하는 수 저장
    val l = ArrayList<Long>()
    (0..9L).forEach { l.add(it) }

    fun insert(i: Long, d: Long, carry: Long) {
        // 마지막 자릿수 까지 왔으면 저장
        if (d == 0L)
            l.add(carry)
        // 바로 앞 숫자보다 작은 수만 들어올 수 있음
        else
            for (j in d - 1 until i)
                insert(j, d - 1, carry * 10 + j)
    }

    if (n > 9)
        // 찾으려고 하는 n번째 감수하는 수 보다 l 의 크기가 작으면 반복
        while (l.size < n + 1) {
            // 10자리 부터는 감소하는 수가 없다
            if (len > 10)
                break
            // 맨 앞자리 설정
            // 맨 뒷자리에 숫자를 넣을 수 있을 만한 숫자부터 시작
            // 2자리 일 경우 2-1 부터 9까지
            // 3자리 일 경우 3-1 부터 9까지
            for (i in len - 1..9L)
                insert(i, len - 1L, i)
            len++
        }
    print(if (n >= l.size) -1 else l[n])
}