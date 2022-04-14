package A1334

fun main() {
    var n: String
    n = "2"
    n = "54"
    n = "45"
    n = "201"
    n = "54321"
    n = "100"
    n = "1"
    n = "11"
    n = "9"
    n = "3999993"
    n = "12345"
    n = "54321"
    n = "99999999999999999999999999999999999999999999999999"
    n = "1999"

    val result = if (n.length == 1 && n.toInt() < 9)
        n.toInt() + 1
    else {
        val l = n.length
        val h = l / 2
        val o = l % 2
        val f = n.slice(IntRange(0, h - 1))
        var r = n.slice(IntRange(0, h + o - 1)) + f.reversed()
        println(r)
        if (r.toFloat() <= n.toFloat()) {
            var fm = (n.slice(IntRange(0, h + o - 1)).toFloat() + 1).toString().split(".")[0]
            // var mid = n.slice(IntRange(h, h + o - 1))
            if((h + o - 1) % 2 == 0) {

            } else {

            }
            println(fm)
            println(fm.reversed())
            return
        }
        r
    }
    print(result)
}