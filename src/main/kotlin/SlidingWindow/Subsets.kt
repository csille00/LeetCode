package org.example.SlidingWindow

fun main(){
    println(subsets(intArrayOf(1,2,3)))
}

fun subsets(nums: IntArray): List<List<Int>> {
    val powerset: MutableList<List<Int>> = mutableListOf()
    var subset: MutableList<Int> = mutableListOf()

    fun backtrack(list: List<Int>, start: Int){
        powerset.add(ArrayList(subset))

        for(i in start until list.size){
            subset.add(list[i])
            backtrack(list, i+1)
            subset.removeAt(subset.size - 1)
        }
    }
    backtrack(nums.toList(), 0)
    return powerset
}