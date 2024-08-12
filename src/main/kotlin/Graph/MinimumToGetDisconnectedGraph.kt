package Graph

import java.util.LinkedList
import java.util.Queue

//[0,1,1,0],
//[0,1,1,0],
//[0,0,0,0]
fun main() {
    println(
        minDays(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(0, 0, 0)
            )
        )
    )
}

fun minDays(grid: Array<IntArray>): Int {

    //function count counts the number of islands.
    fun count (): Int {
        /*
        function dfs takes a location, row, col, and for each cardinal direction, if it is also connected land, it sets
        that land to 2 as a way to mark it as visited. this way, the function runs from each individual piece of land
        to find other connected land
         */
        fun dfs(row: Int, col: Int){
            grid[row][col] = 2
            val up = if(col + 1 < grid[0].size) grid[row][col+1] else 0
            val down = if(col - 1 >= 0) grid[row][col - 1] else 0
            val left = if(row + 1 < grid.size) grid[row+1][col] else 0
            val right = if(row - 1 >= 0) grid[row - 1][col] else 0
            if(up == 1) dfs(row, col+1)
            if(down == 1) dfs(row, col - 1)
            if(left == 1) dfs(row+1, col)
            if(right == 1) dfs(row - 1, col)
        }
        var islandCount = 0
        for(i in grid.indices){
            for(j in grid[0].indices){
                //for each piece of unmarked land, run the dfs on it, which will turn each connected piece of land to two
                //and iterate the island count. If another 1 is found after the first running of dfs, then its a second island and so on
                if(grid[i][j] == 1){
                    dfs(i, j)
                    islandCount++
                }
            }
        }

        //reset 2's back to 1 to preserve state
        grid.forEach { row ->
            row.forEachIndexed { index, element ->
                if (element == 2) {
                    row[index] = 1
                }
            }
        }
        return islandCount
    }

    //if the initial count is not 1, the graph is already disconnected
    if(count() != 1) return 0

    //for each piece of land, change it to water, and see if the count is no longer 1. if it is, return 1 movement.
    //otherwise, change it back to 1 and keep going. if you get all the way through each piece of land, then return 2
    for(i in grid.indices){
        for(j in grid[0].indices){
            if(grid[i][j] == 1) {
                grid[i][j] = 0
                if(count() != 1) return 1
                grid[i][j] = 1
            }
        }
    }

    //any island of any shape can have an isolated in at most 2 moves. if one move didn't work, then two will.
    return 2
}