package BinarySearch

import TreeNode
import createBinaryTree



fun main() {
    val root = createBinaryTree(
        arrayOf(
            intArrayOf(5, 1, 1),
            intArrayOf(1, 3, 1),
            intArrayOf(5, 2, 0),
            intArrayOf(2, 6, 1),
            intArrayOf(2, 4, 0),
        )
    )

    getDirections(root, 6, 4)
}

fun thirdMax(nums: IntArray): Int {
    val set = nums.toList().toSet()
    var list = set.toList()
    list = list.sorted()
    if(list.size <= 3) return list[0]
    return list[list.size - 4]
}

fun getDirections(root: TreeNode, startValue: Int, destValue: Int): String {

    //simple depth first search function
    fun dfs(path: StringBuilder = StringBuilder(), root: TreeNode? = null, value: Int): Boolean{
        if(root == null) return false
        if(root.`val` == value) return true

        path.append("L")
        if(dfs(path, root.left, value)) return true
        path.deleteCharAt(path.lastIndex)

        path.append("R")
        if(dfs(path, root.right, value)) return true
        path.deleteCharAt(path.lastIndex)

        return false
    }

    //create stringbuilders to pass in
    val startStringBuilder = StringBuilder()
    val endStringBuilder = StringBuilder()
    dfs(path = startStringBuilder,  root = root, value = startValue)
    dfs(path = endStringBuilder,root = root, value = destValue)

    //chop off the first characters in the paths until they're different
    while(startStringBuilder.isNotEmpty() && endStringBuilder.isNotEmpty() && startStringBuilder[0] == endStringBuilder[0]){
        startStringBuilder.deleteCharAt(0)
        endStringBuilder.deleteCharAt(0)
    }
    //change all the first string's path to U and just join it to the second string
    return startStringBuilder.toString().map { 'U' }.joinToString("") + endStringBuilder.toString()
}