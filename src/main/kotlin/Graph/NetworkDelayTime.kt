package Graph

import array_string.relativeSortArray
import java.util.PriorityQueue
import kotlin.math.min

//[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
fun main(){
    val times = arrayOf(
        intArrayOf(2,1,1),
        intArrayOf(2,3,1),
        intArrayOf(3,4,1)
    )
//    val times = arrayOf(intArrayOf(1,2,1))
//    val times = arrayOf(
//        intArrayOf(1,2,1),
//        intArrayOf(2,1,3)
//    )
//    [1,2,1],[2,3,2],[1,3,1]
//    val times = arrayOf(
//        intArrayOf(1,2,1),
//        intArrayOf(2,3,2),
//        intArrayOf(1,3,1)
//    )
    val n = 4
    val k = 2
    println(networkDelayTimeA(times, n, k))
}

fun networkDelayTimeA(times: Array<IntArray>, n: Int, k: Int): Int {
    val matrix = MutableList(n+1) {MutableList(n+1) {1000} }
    for(time in times){
        matrix[time[0]][time[0]] = 0
        matrix[time[1]][time[1]] = 0
        matrix[time[0]][time[1]] = time[2]
    }

    for(l in 1 until n + 1) {
        for (i in 1 until n + 1) {
            for (j in 1 until n + 1) {
                matrix[i][j] = min(matrix[i][j], matrix[i][l] + matrix[l][j])
            }
        }
    }
    val result = matrix[k].subList(1, n+1).max()
    return if(result == 1000) -1 else result

//    return if (result.size == 0 || result.max() == 0) -1 else result.max()
}

fun networkDelayTimeB(times: Array<IntArray>, n: Int, k: Int): Int {
    val timeTo = IntArray(n) { Int.MAX_VALUE }
    timeTo[k-1] = 0
    repeat(n-1) {
        times.forEach { (from,to,time)->
            timeTo[to-1] = minOf(timeTo[from-1] + time, timeTo[to-1])
        }
    }
    return when(val result = timeTo.max()!!) {
        Int.MAX_VALUE -> -1
        else -> result
    }
}
