package binary_tree.search_tree

import binary_tree.BinaryNode

class BinarySearchTree<T : Comparable<T>> {
    var root: BinaryNode<T>? = null
    val isBinaryTree: Boolean
        get() = isBST(this.root, null, null)

    override fun toString() = root?.toString() ?: "empty tree"

    fun insert(value: T) {
        root = insert(root, value)
    }

    fun getMin() = this.root?.min

    private fun insert(node: BinaryNode<T>?, value: T): BinaryNode<T> {
        node ?: return BinaryNode(value)

        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value)
        } else {
            node.rightChild = insert(node.rightChild, value)
        }
        return node
    }

    fun contains(value: T): Boolean {
        root ?: return false
        var found = false
        root?.travelInOrder {
            if (value == it) found = true
        }
        return found
    }

    fun containsOptimized(value: T): Boolean {
        var current = root

        while (current != null) {
            if (current.value == value) return true

            current = if (value < current.value) current.leftChild else current.rightChild
        }
        return false
    }

    fun remove(value: T) {
        root = remove(root, value)
    }

    private fun remove(node: BinaryNode<T>?, value: T): BinaryNode<T>? {
        node ?: return null
        when {
            value == node.value -> {
                if (node.leftChild == null && node.rightChild == null)
                    return null
                if (node.leftChild == null)
                    return node.rightChild
                if (node.rightChild == null)
                    return node.leftChild

                node.rightChild?.min?.value?.let {
                    node.value = it
                }

                node.rightChild = remove(node.rightChild, node.value)
            }

            value < node.value -> node.leftChild = remove(node.leftChild, value)

            else -> node.rightChild = remove(node.rightChild, value)
        }
        return node
    }

    private fun isBST(node: BinaryNode<T>?, min: T?, max: T?): Boolean {
        node ?: return true
        if (min != null && min >= node.value) return false
        else if (max != null && max < node.value) return false

        return isBST(node.leftChild, min, node.value)
    }

    fun containSub(subTree: BinarySearchTree<T>?): Boolean {
        val set = mutableSetOf<T?>()
        root?.travelInOrder {
            set.add(it)
        }

        var isEqual = true
        subTree?.root?.travelInOrder {
            isEqual = isEqual && set.contains(it)
        }
        return isEqual
    }
}
