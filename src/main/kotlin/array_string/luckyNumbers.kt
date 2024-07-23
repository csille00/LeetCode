package array_string

import kotlin.math.sign


fun main(){
    println(luckyNumbers(
        arrayOf(
            intArrayOf(3,7,8),
            intArrayOf(9,11,13),
            intArrayOf(15,16,17)
        )
    ))
}

//[3, 7, 8]
//[9, 11,13],
//[15,16,17]

fun luckyNumbers (matrix: Array<IntArray>): List<Int> {
        val minInRowList = mutableListOf<Int>()
        val maxInColList = MutableList(matrix[0].size){Int.MIN_VALUE}
        val result = mutableListOf<Int>()

        for(rowIndex in matrix.indices){
            var minInRow = Int.MAX_VALUE
            for(colIndex in matrix[rowIndex].indices){
                val curNum = matrix[rowIndex][colIndex]
                if(curNum < minInRow) minInRow = curNum
                if(curNum > maxInColList[colIndex]) maxInColList[colIndex] = curNum
                if(rowIndex == matrix.lastIndex && minInRow == maxInColList[colIndex]){
                    result.clear()
                    result.add(minInRow)
                }
            }
            minInRowList.add(minInRow)
        }
        return result
}