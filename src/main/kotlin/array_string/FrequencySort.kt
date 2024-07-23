package array_string

fun main(){
    println(frequencySort(intArrayOf(2,3,1,3,2)))
}

fun frequencySort(nums: IntArray): IntArray {
    var map = mutableMapOf<Int, Int>()
    for(num in nums){
        map[num] = map.getOrDefault(num, 0) + 1
    }
    var newMap = map.toList().sortedWith(compareBy({ it.second }, { -it.first })).toMap()
    val result = mutableListOf<Int>()
    newMap.forEach { (k, v) ->  repeat(v) { result.add(k) } }
    return result.toIntArray()
}