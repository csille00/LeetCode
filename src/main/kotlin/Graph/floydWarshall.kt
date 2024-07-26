package Graph

import kotlin.math.min

fun main(){
    var edges = arrayOf(
        intArrayOf(0,1,3),
        intArrayOf(1,2,1),
        intArrayOf(1,3,4),
        intArrayOf(2,3,1)
    )
    val n = 4
    val threshold = 4
    println(findTheCity(n, edges, threshold))
}

    fun findTheCity(n: Int, edges: Array<IntArray>, distanceThreshold: Int): Int {
        val initialMatrix = MutableList(n) { MutableList(n) {100_000} }
        for(edge in edges){
            initialMatrix[edge[0]][edge[1]] = edge[2]
            initialMatrix[edge[1]][edge[0]] = edge[2]
        }

        //dp floyd-warshall
        //k = vertice that is to be the intermediate
        for(k in 0 until n){
            //loop through each vertex and see if putting k as an intermediate is cheaper than just going from i,j
            for(i in 0 until n){
                for(j in 0 until n){
                    initialMatrix[i][j] = min(initialMatrix[i][j], initialMatrix[i][k] + initialMatrix[k][j])
                }
            }
        }

        //find city with fewest num in-distance cities
        var result = 0
        var numCitiesReachable = Int.MAX_VALUE
        for(i in 0 until n){
            var tempNumCitiesReachable = 0
            for(j in 0 until n){
                if(j == i) continue
                if(initialMatrix[i][j] <= distanceThreshold) tempNumCitiesReachable++
            }
            if(tempNumCitiesReachable <= numCitiesReachable){
                numCitiesReachable = tempNumCitiesReachable
                result = i
            }
        }

        return result
    }