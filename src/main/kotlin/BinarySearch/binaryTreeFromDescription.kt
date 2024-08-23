/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
//[[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]

fun main() {
    println(
//        createBinaryTree(
//            arrayOf(
//                intArrayOf(20, 15, 1),
//                intArrayOf(20, 17, 0),
//                intArrayOf(50, 20, 1),
//                intArrayOf(50, 80, 0),
//                intArrayOf(80, 18, 1)
//            )
//        )
//        [85,82,1],[74,85,1],[39,70,0],[82,38,1],[74,39,0],[39,13,1]
        createBinaryTree(
            arrayOf(
                intArrayOf(85, 82, 1),
                intArrayOf(74, 85, 1),
                intArrayOf(39, 70, 0),
                intArrayOf(82, 38, 1),
                intArrayOf(74, 39, 0),
                intArrayOf(39, 13, 1)
            )
        )
    )
}

fun createBinaryTree(descriptions: Array<IntArray>): TreeNode {
    //[parent, child, isleft]

    //initialize mop of val to node for easy reference to already added nodes
    val nodesAdded = mutableMapOf<Int, TreeNode>()
    //since there could be multiple unconnected trees at a time, make a list of roots
    val curRoots: MutableList<TreeNode> = mutableListOf()

    for (node in descriptions.indices) {
        //check if parent node exists
        var parentNode: TreeNode? = nodesAdded.getOrDefault(descriptions[node][0], null)

        //if it does not, then make a new node, add it to the map and the roots list, and set that as the parent for this particular child
        if (parentNode == null) {
            val newRoot = TreeNode(descriptions[node][0])
            nodesAdded[newRoot.`val`] = newRoot
            curRoots.add(newRoot)
            parentNode = newRoot
        }

        //make or get the new child node
        var nodeToAdd = nodesAdded.getOrDefault(descriptions[node][1], null)

        if(nodeToAdd == null){
            nodeToAdd = TreeNode(descriptions[node][1])
            nodesAdded[nodeToAdd.`val`] = nodeToAdd
        } else {
            //if the child node that we just got is a root list, it is no longer a root
            curRoots.remove(nodeToAdd)
        }

        if (descriptions[node][2] == 1) parentNode.left = nodeToAdd else parentNode.right = nodeToAdd

    }
    return curRoots[0]
}
