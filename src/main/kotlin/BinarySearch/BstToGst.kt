package BinarySearch

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

fun main(){
    var sol = Solution()
//    println(sol.bstToGst())
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

internal class Solution {

        class Solution {

            fun bstToGst(root: TreeNode?): TreeNode? {
                //the idea here is to do a right to left search of the tree, so that we can get the biggest
                //value in the tree (the far right val) and then slowly go backwards from there, keeping a
                //running sum of each value we've visited up to that point
                //we then add each value to our running sum as we go, so the values that are closest to the largest
                //value in the tree get the least added to, and the smallest value in the tree (far left) will get
                //the most added to it since it's the last one to be visited.

                //initialize sum to 0 because once we get to the far right value, we won't want to add anything to it;
                var sum = 0

                fun traverse(node: TreeNode?) {
                    //return and do nothing for a null node
                    if(node == null) return

                    //go right until you can't anymore
                    traverse(node.right)
                    //add the node's value to the running sum
                    sum += node.`val`
                    //reassign the node's value to its current value, plus every node you've visited so far
                    node.`val` = sum
                    //now call traverse on the left subtree. this works because everything in the left subtree
                    //is smaller than the right subtree, so it needs the entirety of the right subtree to be added to it
                    traverse(node.left)
                }

                traverse(root)
                return root
            }
        }
    }


