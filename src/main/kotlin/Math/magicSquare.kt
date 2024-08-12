package Math

//[4,3,8,4],[9,5,1,9],[2,7,6,2]

//[2,7,6],[1,5,9],[4,3,8]

fun main() {
//    val grid = arrayOf(
//        intArrayOf(4, 3, 8, 4),
//        intArrayOf(9, 5, 1, 9),
//        intArrayOf(2, 7, 6, 2)
//    )
    val grid = arrayOf(
        intArrayOf(7, 0, 5),
        intArrayOf(2, 4, 6),
        intArrayOf(3, 8, 1)
    )

//    [7,0,5],[2,4,6],[3,8,1]

    println(numMagicSquaresInside(grid))
}

fun numMagicSquaresInside(grid: Array<IntArray>): Int {
    var result = 0

    fun isMagicSquare(grid: List<IntArray>): Boolean {
        val sum = grid[0].sum()
        var diag1 = 0
        var diag2 = 0
        for (i in grid.indices) {
            if (grid[i].toSet().size != grid[i].size) return false
            if (grid[i].max() > 9 || grid[i].min() < 1) return false
            if (grid[i].sum() != sum) return false

            val temp = grid[0][i] + grid[1][i] + grid[2][1]
            if (temp != sum) return false

            diag1 += grid[i][i]
            diag2 += grid[grid.size - 1 - i][grid.size - 1 - i]
        }
        return !(diag1 != sum || diag2 != sum)
    }

    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (i + 2 < grid.size && j + 2 < grid[i].size) {
                val tempGrid = grid.sliceArray(IntRange(i, i + 2)).map { row -> row.sliceArray(IntRange(j, j + 2)) }
                if (isMagicSquare(tempGrid)) result++
            }
        }
    }

    return result
}