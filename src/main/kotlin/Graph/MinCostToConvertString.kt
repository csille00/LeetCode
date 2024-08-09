package Graph

import kotlin.math.abs
import kotlin.math.min

//Input: source = "abcd",
//target = "acbe",
//original = ["a","b","c","c","e","d"],
//changed = ["b","c","b","e","b","e"],
//cost = [2,5,5,1,2,20]

fun main(){
    val source = "abcd"
    val target = "acbe"
    val original = charArrayOf('a', 'b', 'c', 'c', 'e', 'd')
    val changed = charArrayOf('b', 'c', 'b', 'e', 'b', 'e')
    val cost = intArrayOf(2,5,5,1,2,20)
    println(minimumCost(source, target, original, changed, cost))
}

fun minimumCost(source: String, target: String, original: CharArray, changed: CharArray, cost: IntArray): Long {
    var graph = MutableList(26) {MutableList(26) { 100_000_000_000L } }
    for(i in original.indices){
        graph[original[i] - 'a'][changed[i] - 'a'] = cost[i].toLong()
    }

    //because some of the edges can be repeated, you have to initialize the graph with the minimum edge
    for (i in original.indices) {
        val u = original[i] - 'a'
        val v = changed[i] - 'a'
        graph[u][v] = minOf(cost[i].toLong(), graph[u][v])
    }


    for(k in 0 until 26){
        for(i in 0 until 26){
            for(j in 0 until 26){
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])
            }
        }
    }

    var result = 0L
    for(i in source.indices){
        if(source[i] == target[i]) continue
        if(graph[source[i] - 'a'][target[i] - 'a'] == 100_000_000_000L) return -1
        result += graph[source[i] - 'a'][target[i] - 'a']
    }

    return result
}