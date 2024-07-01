package Greedy

fun main(){
    val sol: Solution = Solution()
//    println(sol.maximumImportance(5, arrayOf(intArrayOf(0,1), intArrayOf(1,2), intArrayOf(2,3), intArrayOf(0,2),intArrayOf(1,3),intArrayOf(2,4))))
    println(sol.maximumImportance(5, arrayOf(intArrayOf(0,1))))
}

class Solution {
    fun maximumImportance(n: Int, roads: Array<IntArray>): Long {
        //I first want to come up with a mechanism for counting the edges for each node.
        //from there, I can just do a greedy approach and assign the biggest values with the ones with the most edges.

        val edgeCounts = mutableMapOf<Int, Int>()
        for (road in roads) {
            edgeCounts[road[0]] = edgeCounts.getOrDefault(road[0], 0) + 1
            edgeCounts[road[1]] = edgeCounts.getOrDefault(road[1], 0) + 1
        }
        val edgeCountsSorted = edgeCounts.toList().sortedByDescending { (_, value) -> value}

        val weights = IntArray(n)

        for(i in edgeCountsSorted.indices){
            weights[edgeCountsSorted[i].first] = n-i
        }

        var sum: Long = 0

        for(edge in roads){
            sum += weights[edge[0]] + weights[edge[1]]
        }

        return sum
    }
}