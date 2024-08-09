package Math

fun main() {
    println(reverse(1534236469))
}

fun reverse(x: Int): Int {
    var stringX = x.toString()
    if (stringX[0] == '-') {
        stringX = stringX.drop(1)
        return try {
            stringX.reversed().toInt() * -1
        } catch (e: NumberFormatException) {
            0
        }
    } else {
        return try {
            stringX.reversed().toInt()
        } catch (e: NumberFormatException) {
            0
        }
    }
}