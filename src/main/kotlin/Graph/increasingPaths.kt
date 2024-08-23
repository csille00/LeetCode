package Graph

fun main() {
    println(
        countPaths(
            arrayOf(
                intArrayOf(0, 4, 3),
                intArrayOf(5, 8, 9),
                intArrayOf(5, 9, 9)
            )
        )
    )
}

fun countPaths(grid: Array<IntArray>): Int {
    val numRows = grid.size
    val numCols = grid[0].size
    val dp = MutableList(numRows) {MutableList(numCols) {-1L} }
    val directions = listOf(Pair(0,1), Pair(1,0), Pair(-1, 0), Pair(0, -1))
    val mod = 1_000_000_000_7

    fun paths(i: Int, j: Int): Long{
        if(dp[i][j] != -1L) return dp[i][j]
        var count = 1L
        for(direction in directions){
            val newI = i + direction.first
            val newJ = j + direction.second
            if(newI in 0 until numRows && newJ in 0 until numCols && grid[newI][newJ] > grid[i][j]) {
                count += paths(newI, newJ)
                count %= mod
            }
        }
        dp[i][j] = count
        return count
    }
    var result = 0L
    for(i in 0 until numRows){
        for(j in 0 until numCols){
            result += paths(i, j)
            result %= mod
        }
    }
    return result.toInt()
}