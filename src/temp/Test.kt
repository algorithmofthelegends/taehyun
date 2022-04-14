package temp

fun main() {
    val cnt = 9
    val size = 3;
    val data = "1 2 3 4 5 6 7 8 9".split(" ").map { it.toInt() }

    for (i in 1..cnt - size) {
        slice(data, i, size, cnt - size);
    }
}

fun slice(data: List<Int>, num: Int, size: Int, end: Int) {
    if (num < size) {
        for (i in 1..size - num) {
            slice(data, i, size, end - i);
        }
    }
}