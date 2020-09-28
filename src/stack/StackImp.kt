package stack

class StackImp<T> : Stack<T> {
    private val storage = arrayListOf<T>()

    override val count: Int
        get() = storage.size

    val isEmpty: Boolean
        get() = count == 0


    override fun push(element: T) {
        storage.add(element)
    }

    override fun pop(): T? {
        if (storage.isEmpty()) return null
        return storage.removeAt(storage.size - 1)
    }

    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override fun toString(): String {
        return buildString {
            appendln("----Top----")
            storage.asReversed().forEach {
                appendln("$it")
            }
            appendln("-----------")
        }
    }

    companion object {
        fun <E> create(items: Iterable<E>): Stack<E> {
            val stack = StackImp<E>()
            for (item in items) {
                stack.push(item)
            }
            return stack
        }
    }
}
