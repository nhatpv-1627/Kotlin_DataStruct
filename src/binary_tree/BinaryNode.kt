package binary_tree

import kotlin.math.max

class BinaryNode<T>(var value: T) {

    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null
    val min: BinaryNode<T>?
        get() = leftChild?.min ?: this

    fun travelInOrder(visitor: Visitor<T>) {
        visitor(value)
        leftChild?.travelInOrder(visitor)
        rightChild?.travelInOrder(visitor)
    }

    fun height(node: BinaryNode<T>? = this): Int {
        return node?.let {
            1 + max(
                height(it.leftChild),
                height(it.rightChild)
            )
        } ?: 0
    }

    private fun traversePreOrderWithNull(visit: Visitor<T>) {
        visit(value)
        leftChild?.traversePreOrderWithNull(visit) ?: visit(null)
        rightChild?.traversePreOrderWithNull(visit) ?: visit(null)
    }

    fun serialize(node: BinaryNode<T> = this): MutableList<T?> {
        val list = mutableListOf<T?>()
        node.traversePreOrderWithNull { list.add(it) }
        return list
    }

    fun deserialize(list: MutableList<T?>): BinaryNode<T?>? {
        val rootValue = list.removeAt(list.size - 1) ?: return null
        val root = BinaryNode<T?>(rootValue)
        root.leftChild = deserialize(list)
        root.rightChild = deserialize(list)
        return root
    }

    fun deserializeOptimized(list: MutableList<T?>): BinaryNode<T?>? {
        return deserialize(list.asReversed())
    }

    override fun toString(): String = diagram(this)

    fun diagram(
        node: BinaryNode<T>?, top: String = "",
        root: String = "", bottom: String = ""
    ): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null)
                "$root${node.value}\n"
            else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + diagram(
                    node.leftChild,
                    "$bottom│ ", "$bottom└──", "$bottom "
                )
            }
        } ?: "${root}null\n"
    }
}
