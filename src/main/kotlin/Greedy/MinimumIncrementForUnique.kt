package Greedy

fun main(){
    println(minIncrementForUnique(intArrayOf(1,2,2)))
}

fun minIncrementForUnique(nums: IntArray): Int {
    var moves = 0
    nums.sort()
    val seen = mutableMapOf<Int, Int>()
    for(i in nums.indices){
        seen.getOrElse(nums[i]) {seen.put(nums[i], 1)}
    }
    return 1
}