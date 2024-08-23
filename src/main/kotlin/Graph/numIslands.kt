package Graph

import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

//[1,1,1],[1,1,0],[1,0,1]
//[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]
fun main() {
//    val grid = arrayOf(intArrayOf(0,1,0,0), intArrayOf(1,1,1,0), intArrayOf(0,1,0,0), intArrayOf(1,1,0,0))
//    val grid = arrayOf(
//        charArrayOf('1'),
//        charArrayOf('1')
//    )
//    println(islandPerimeter(arrayOf(intArrayOf(1, 1))))
    val grid: Array<IntArray> = arrayOf(
        intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0)
    )
    println(maxAreaOfIsland(grid))
}


fun numIslands(grid: Array<CharArray>): Int {
    var result = 0
    val directions = listOf(Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1))
    fun find(i: Int, j: Int) {
        for (coord in directions) {
            val newI = i + coord.first
            val newJ = j + coord.second
            if (newI in grid.indices && newJ in grid[0].indices && grid[newI][newJ] == '1') {
                grid[newI][newJ] = '2'
                find(newI, newJ)
            }
        }
    }

    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == '1') {
                result++
                find(i, j)
            }
        }
    }
    return result
}

fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
    val directions = listOf(Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1))
    val startColor = image[sr][sc]
    if (startColor == color) return image
    fun flood(i: Int, j: Int) {
        for (coord in directions) {
            val newI = i + coord.first
            val newJ = j + coord.second
            if (newI in image.indices && newJ in image[0].indices && image[newI][newJ] == startColor) {
                image[newI][newJ] = color
                flood(newI, newJ)
            }
        }
    }
    image[sr][sc] = color
    flood(sr, sc)
    return image
}

fun floodFillBfs(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
    val directions = listOf(Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1))
    val startColor = image[sr][sc]
    if (startColor == color) return image
    val q: Queue<Pair<Int, Int>> = LinkedList()
    image[sr][sc] = color
    q.add(Pair(sr, sc))
    while (q.isNotEmpty()) {
        val pixel = q.remove()
        for (coord in directions) {
            val newI = pixel.first + coord.first
            val newJ = pixel.second + coord.second
            if (newI in image.indices && newJ in image[0].indices && image[newI][newJ] == startColor) {
                image[newI][newJ] = color
                q.add(Pair(newI, newJ))
            }
        }
    }
    return image
}

fun islandPerimeter(grid: Array<IntArray>): Int {
    val directions =
        listOf(Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1)) //down first, then right, then up, then left
    var result = 0
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == 1) {
                for (dir in directions) {
                    val newI = i + dir.first
                    val newJ = j + dir.second
                    if (newI !in grid.indices || newJ !in grid[0].indices || grid[newI][newJ] == 0) result++
                }
            }
        }
    }
    return result
}

fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    var maxArea = 0
    val visited = List(grid.size) { MutableList(grid[0].size) { false } }
    fun bfs(i: Int, j: Int): Int {
        var area = 0
        val directions =
            listOf(Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1)) //down first, then right, then up, then left
        val q: Queue<Pair<Int, Int>> = LinkedList()
        q.add(Pair(i, j))
        while(q.isNotEmpty()){
            val cur = q.remove()
            for(coord in directions) {
                val newI = cur.first + coord.first
                val newJ = cur.second + coord.second
                if (newI in grid.indices && newJ in grid[0].indices && grid[newI][newJ] == 1 && !visited[newI][newJ]) {
                    area ++
                    q.add(Pair(newI, newJ))
                    visited[newI][newJ] = true
                }
            }
        }
        return if(area == 0) 1 else area
    }
    for(i in grid.indices){
        for(j in grid[0].indices){
            if(grid[i][j] == 1 && !visited[i][j]){
                maxArea = max(maxArea, bfs(i, j))
            }
        }
    }
    return maxArea
}