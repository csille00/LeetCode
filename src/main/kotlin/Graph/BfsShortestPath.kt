package Graph

import java.util.*
import kotlin.math.max
import kotlin.math.min

fun main() {
    //    [0,0,0],
    //    [1,1,0],
    //    [1,1,0]

    //    [1,0,0],
    //    [1,1,0],
    //    [1,1,0]
    println(shortestPathBinaryMatrix(arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 1, 0), intArrayOf(1, 1, 0))))
}

fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
    if(grid[0][0] == 1 || grid[grid.size - 1][grid.size - 1] == 1) return -1
    val q: Queue<Triple<Int, Int, Int>> = LinkedList()
    val visited = List(grid.size) { MutableList(grid[0].size) { false } }
    visited[0][0] = true
    val directions = listOf((1 to 0), (-1 to 0), (0 to -1), (0 to 1), (1 to 1), (1 to -1), (-1 to 1), (-1 to -1))
    q.add(Triple(0, 0, 1))
    while (q.isNotEmpty()) {
        val cur = q.poll()
        if(cur.first == grid.size - 1 && cur.first == cur.second) return cur.third

        for(dir in directions){
            val i = cur.first + dir.first
            val j = cur.second + dir.second
            if(i in grid.indices && j in grid.indices && grid[i][j] == 0 && !visited[i][j] ) {
                q.add(Triple(i, j, cur.third + 1))
                visited[i][j] = true
            }
        }
    }
    return -1
}