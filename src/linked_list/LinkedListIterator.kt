package linked_list

class LinkedListIterator<T>(private var list: LinkedList<T>) : MutableIterator<T> {

    private var index = 0
    private var lastNode: Node<T>? = null

    override fun hasNext(): Boolean {
        return index < list.size
    }

    override fun next(): T {
        //1
        if (index >= list.size) throw IndexOutOfBoundsException()
        //2
        lastNode = if (index == 0) list.nodeAt(0) else lastNode?.next
        //3
        index++
        return lastNode!!.value
    }

    override fun remove() {
        // 1
        if (index == 1) list.pop()
        else {
            //2
            val prevNote = list.nodeAt(index - 2) ?: return
            //3
            list.removeAfter(prevNote)
            lastNode = prevNote
        }
        index--

    }
}
