package BinarySearch

import TreeNode
import createBinaryTree

fun main() {
//    [1,2,3,4,5,6,7]
    val root = createBinaryTree(
//        arrayOf(
//            intArrayOf(1, 2, 1),
//            intArrayOf(1, 3, 0),
//            intArrayOf(2, 4, 1),
//            intArrayOf(2, 5, 0),
//            intArrayOf(3, 6, 1),
//            intArrayOf(3, 7, 0),
//        )
        arrayOf(
            intArrayOf(1, 2, 1),
            intArrayOf(2, 4, 1),
            intArrayOf(2, 3, 0)
        )
    )
    delNodes(root, intArrayOf(2,3))

}

fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode?> {

        fun dfs(root: TreeNode?, value: Int, parent: TreeNode? = null): Pair<TreeNode?, TreeNode?> {
            if (root == null) return null to null
            if (root.`val` == value) return root to parent

            val left = dfs(root.left, value, root)
            if (left.first != null) return left

            val right = dfs(root.right, value, root)
            if (right.first != null) return right

            return null to null
        }

        val result: MutableList<TreeNode?> = mutableListOf(root)
        val toDelete: MutableList<TreeNode?> = mutableListOf()

        for (i in to_delete.indices) {
            val (nodeToDelete, parent) = dfs(root, to_delete[i])
            if (nodeToDelete?.left != null) result.add(nodeToDelete.left)
            if (nodeToDelete?.right != null) result.add(nodeToDelete.right)
            toDelete.add(nodeToDelete)
//                if (parent?.left == nodeToDelete) parent?.left = null
//                else parent?.right = null
        }
        for(i in toDelete.indices){
            toDelete[i] = null
            result.remove(toDelete[i])
        }
        return result

}