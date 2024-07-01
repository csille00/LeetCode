package Graph

import kotlin.system.measureTimeMillis

fun main(){
//    [0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]
    //correct: from, to
    //reversed: to, from

    val edges = arrayOf(
        intArrayOf(0, 3), intArrayOf(0, 4), intArrayOf(1, 3), intArrayOf(2, 4),
        intArrayOf(2, 7), intArrayOf(3, 5), intArrayOf(3, 6), intArrayOf(3, 7), intArrayOf(4, 6)
    )

    val timeTaken = measureTimeMillis {
        val ancestors = getAncestors(8, edges)
        println(ancestors)
    }

    println("Time taken: $timeTaken ms")
}

fun getAncestors(n: Int, edges: Array<IntArray>): List<List<Int>> {
    //start by reversing the edges, so that I have each node's ancestors
    //But I actually don't need to 'reverse' them, I just need to understand that conceptually reversing them
    //will point me to each node's ancestors
    //so from is to and to is from

    val result = List(n) { listOf<Int>() }.toMutableList()
    val edgeMap = mutableMapOf<Int, MutableList<Int>>()
    for(edge in edges){
        edgeMap.getOrPut(edge[1]) { mutableListOf() }.add(edge[0])
    }
    //if the first edge is 0, 3, then its an edge going from node 0 to node 3
    //I want to go from node 3 to node 0

    //initialize memoization map to store already computed ancestors
    val memoizedAncestors = mutableMapOf<Int, List<Int>>()

    //recursive found ancestors function to take a single node
    // and find all the previously computed ancestors plus the newly computed ancestors for it
    fun findAncestors(node: Int): List<Int> {
        //if the node we are looking at already contains computed ancestors, just return those
        if(memoizedAncestors.containsKey(node)){
            return memoizedAncestors[node]!!
        }

        //if we have not yet found any ancestors for this node, then make a new set of ancestors
        val ancestors= mutableSetOf<Int>()

        //for each node in the list of ancestors of this node, add the ancestor in the list, as well as each of that ancestors ancestors
        edgeMap[node]?.forEach{ ancestor ->
            ancestors.add(ancestor)
            ancestors.addAll(findAncestors(node))
        }

        //sort the ancestor lists as we make them
        val sortedAncestors = ancestors.toList().sorted()
        //add to the memoized ancestor list
        memoizedAncestors[node] = sortedAncestors
        //return the newly sorted ancestor list
        return sortedAncestors
    }

    for(i in 0 until n){
        result[i] = findAncestors(i)
    }
    return result
}
