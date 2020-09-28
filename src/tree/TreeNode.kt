package tree

import queue.ArrayListQueue

class TreeNode<T>(val value: T) {
    private val children = mutableListOf<TreeNode<T>>()

    fun add(child: TreeNode<T>) = children.add(child)

    fun forEachDepthFirst(visitor: Visitor<T>) {
        visitor(this)
        children.forEach {
            it.forEachDepthFirst(visitor)
        }
    }

    fun forEachLevelOrder(visitor: Visitor<T>) {
        visitor(this)
        val queue = ArrayListQueue<TreeNode<T>>()
        children.forEach {
            queue.enqueue(it)
        }
        var node = queue.dequeue()
        while (node != null) {
            visitor(node)
            node.children.forEach { queue.enqueue(it) }
            node = queue.dequeue()
        }
    }

    fun search(value: T): TreeNode<T>? {
        var result: TreeNode<T>? = null

        forEachLevelOrder {
            if (value == it.value) result = it
        }
        return result
    }

    fun printEachLevel() {
        val queue = ArrayListQueue<TreeNode<T>>()
        var nodesLeftInCurrentLevel = 0
        queue.enqueue(this)
        while (!queue.isEmpty) {
            nodesLeftInCurrentLevel = queue.count
            while (nodesLeftInCurrentLevel > 0) {
                val next = queue.dequeue()
                next?.let {
                    print("${it.value} ")
                    nodesLeftInCurrentLevel--
                    it.children.forEach { child -> queue.enqueue(child) }
                } ?: break
            }
            println()
        }

    }
}

