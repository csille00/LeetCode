package BinarySearch

import TreeNode
import createBinaryTree

fun main(){
    val root = createBinaryTree(
        arrayOf(
            intArrayOf(1, 2, 1),
            intArrayOf(1, 3, 0),
            intArrayOf(2, 4, 1),
            intArrayOf(2, 5, 0),
            intArrayOf(3, 6, 1),
            intArrayOf(3, 7, 0)
        )
    )

    countPairs(root, 3)
}

class CustomTreeNode(var Node: TreeNode?) {
    var parent: TreeNode? = null
}

fun countPairs(root: TreeNode?, distance: Int): Int {
    val leafNodes = mutableListOf<CustomTreeNode>()

    fun findLeaves(root: TreeNode?, parent: TreeNode? = null) {
        if(root == null) return
        if(root.left == null && root.right == null) {
            val nodeToAdd = CustomTreeNode(root)
            nodeToAdd.parent = parent
            leafNodes.add(nodeToAdd)
        }
        findLeaves(root.left, root)
        findLeaves(root.right, root)
    }

    fun dfs(root: CustomTreeNode?, target: CustomTreeNode?, distance: Int): Boolean{
        if(root == null) return false
        if(root == target) return true

        var distanceCopy = distance
        distanceCopy++
        var newNode = CustomTreeNode(root.Node?.left)
        newNode.parent = root.Node
        if(dfs(newNode, target, distanceCopy)) return true

        newNode = CustomTreeNode(root.Node?.right)
        newNode.parent = root.Node
        if(dfs(newNode, target, distanceCopy)) return true

        newNode = CustomTreeNode(root.parent)
        newNode.parent = root.parent
        if(dfs(newNode, target, distanceCopy)) return true
        distanceCopy--

        return false

    }

    findLeaves(root)

    return 1
}