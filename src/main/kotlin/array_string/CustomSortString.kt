package array_string

fun main(){
    println(customSortString("bcafg", "abcd"))
}

fun customSortString(order: String, s: String): String {
    s.toList().sorted()
    val freqMap = mutableMapOf<Int, Int>()
    val nums = intArrayOf(1,2,3,4)
    nums.sort()
    nums.toHashSet()
    return ""
}