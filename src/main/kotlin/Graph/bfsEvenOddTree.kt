package Graph

import TreeNode
import createBinaryTree
import java.util.*

//1,10,4,3,null,7,9,12,8,6,null,null,2
//[11,12,8,3,7,11,null,null,null,20]


fun main() {
    val root = createBinaryTree(
        arrayOf(
            intArrayOf(1, 10, 1),
            intArrayOf(1, 4, 0),
            intArrayOf(10, 3, 1),
            intArrayOf(4, 7, 1),
            intArrayOf(4, 9, 0),
            intArrayOf(3, 12, 1),
            intArrayOf(3, 8, 0),
            intArrayOf(7, 6, 1),
            intArrayOf(9, 2, 1)
        )
    )

//    val root = createBinaryTree(
//        arrayOf(
//            intArrayOf(11, 12, 1),
//            intArrayOf(11, 8, 0),
//            intArrayOf(12, 3, 1),
//            intArrayOf(12, 3, 0),
//            intArrayOf(8, 11, 1),
//            intArrayOf(7, 20, 1)
//        )
//    )
    println(isEvenOddTree(root))
}

fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {

    fun dfs(root: TreeNode?, target: Int): TreeNode? {
        if(root == null) return null

        println("root in dfs: ${root.`val`}")

        var temp = dfs(root.left, target)
        if(temp != null) return temp
        temp = dfs(root.right, target)
        if(temp != null) return temp

        return null
    }

    fun inSync(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if(root == null || subRoot == null) return false

        println("root val: $root.`val`, subRoot val: $subRoot.`val`")

        if(root.`val` != subRoot.`val`) return false

        if(inSync(root.left, subRoot.left)) return true
        if(inSync(root.right, subRoot.right)) return true

        return true
    }

    if(subRoot == null) return false
    val node = dfs(root, subRoot.`val`)
    println("found node: $node.`val`")
    if(node == null) return false

    return inSync(node, subRoot)


}

fun isEvenOddTree(root: TreeNode?): Boolean {
    if (root == null) return false

    //begin bfs algorithm by initializing a queue. we don't need a visited list since its a binary tree
    val q: Queue<Pair<TreeNode, Int>> = LinkedList()

    val valid = true
    q.add(Pair(root, 0))
    //keep track of the previously visited node so that we can tell if it's increasing or decreasing
    var prev: TreeNode? = null
    //keep track of the prevLevel so that we can tell if we are at the beginning of a level, and set prev to null
    var prevLevel = 0
    while (q.isNotEmpty()) {
        val (curNode, level) = q.remove()
        //if we have started a new level, set prev to null since its the first of a new level
        if (level != prevLevel) prev = null

        //we have started a new level
        println("level: $level")
        println(curNode.`val`)
        if (level % 2 == 0) {
            if (curNode.`val` % 2 == 0) return false
            if (prev != null && prev.`val` >= curNode.`val`) return false
        } else {
            if (curNode.`val` % 2 == 1) return false
            if (prev != null && prev.`val` <= curNode.`val`) return false
        }

        //if left or right haven't been visited, enqueue them
        curNode.left?.let {
            q.add(it to level + 1)
        }

        curNode.right?.let {
            q.add(it to level + 1)
        }

        prev = curNode
        prevLevel = level
    }

    return valid
}