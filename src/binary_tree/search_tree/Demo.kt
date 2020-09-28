package binary_tree.search_tree

import binary_tree.BinaryNode

fun main() {
    val binarySearchTree = BinarySearchTree<Int>().apply {
        insert(5)
        insert(7)
        insert(4)
        insert(8)
        insert(2)
        insert(2)
        insert(1)
        insert(10)
    }
    println(binarySearchTree)
    //println(binarySearchTree.containsOptimized(2))
    //println(binarySearchTree.getMin())
   //binarySearchTree.remove(7)
    //println(binarySearchTree)
    println(binarySearchTree.isBinaryTree)

}
