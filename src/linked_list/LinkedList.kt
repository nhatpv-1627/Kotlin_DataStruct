package linked_list

class LinkedList<T> : MutableCollection<T> {
    var head: Node<T>? = null
    private var tail: Node<T>? = null
    override var size = 0
        private set

    override fun add(element: T): Boolean {
        append(element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean {
        elements.forEach {
            append(it)
        }
        return true
    }

    override fun remove(element: T): Boolean {
        //1
        val iterator = iterator()
        //2
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (item == element) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        elements.forEach {
            result = remove(it) || result
        }
        return result
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        var result = false
        val iterator = iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (!elements.contains(item)) {
                iterator.remove()
                result = true
            }
        }
        return result
    }

    override fun contains(element: T): Boolean {
        for (item in this) {
            if (element == item) return true
        }
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        elements.forEach {
            if (!contains(it)) return false
        }
        return true
    }

    override fun iterator(): MutableIterator<T> {
        return LinkedListIterator(this)
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty list"
        } else {
            head.toString()
        }
    }

    fun push(value: T): LinkedList<T> {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    fun pop(): T? {
        if (!isEmpty()) size--
        val result = head?.value
        if (isEmpty()) tail = null
        head = head?.next
        return result
    }

    fun removeLast(): T? {

        val head = head ?: return null
        if (head.next == null) return pop()
        size--

        var prev = head
        var current = head
        var next = current.next
        while (next != null) {
            prev = current
            current = next
            next = current.next
        }

        prev.next = null
        tail = prev
        return current.value
    }

    fun append(value: T): LinkedList<T> {
        // 1
        if (isEmpty()) {
            push(value)
            return this
        }
        // 2
        tail?.next = Node(value = value)
        // 3
        tail = tail?.next
        size++
        return this
    }

    fun nodeAt(index: Int): Node<T>? {
        // 1
        var currentNode = head
        var currentIndex = 0
        // 2
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }

    fun insert(value: T, afterNode: Node<T>): Node<T> {
        // 1
        if (tail == afterNode) {
            append(value)
            return tail!!
        }
        // 2
        val newNode = Node(value = value, next = afterNode.next)
        // 3
        afterNode.next = newNode
        size++
        return newNode
    }

    fun removeAfter(afterNode: Node<T>): T? {
        val result = afterNode.next?.value
        if (afterNode.next == tail) tail = afterNode

        if (afterNode.next != null) size--

        afterNode.next = afterNode.next?.next
        return result
    }
}
